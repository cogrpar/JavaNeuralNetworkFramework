# this code is an autoencoder to help optimize the Java Neural Network by compressing the inputs to the size of the Java network height

from keras.layers import Input, Dense
from keras.models import Model
from keras import optimizers
from keras import regularizers
from tensorflow import keras

# ask the user if they want to load from the model

load = input("Would you like to load the autoencoder from the saved model (y/n):  ")

if (load == 'y'): # if they answer yes
    print("loading model...\n")
    autoencoder = keras.models.load_model('autoencoder_model_saves/autoencoder.h5') # load the models
    encoder = keras.models.load_model('autoencoder_model_saves/encoder.h5')
    decoder = keras.models.load_model('autoencoder_model_saves/decoder.h5')
    print("Done")


elif (load == 'n'): # if they answer no
    # this is the size of our encoded representations
    encoding_dim = 10  # 10 floats

    # this is our input placeholder
    input_img = Input(shape=(784,))
    # "encoded" is the encoded representation of the input
    encoded = Dense(encoding_dim, activation='relu', activity_regularizer=regularizers.l1(10e-5))(input_img)
    # "decoded" is the lossy reconstruction of the input
    decoded = Dense(784, activation='sigmoid')(encoded)

    # this model maps an input to its reconstruction
    autoencoder = Model(input_img, decoded)

    # this model maps an input to its encoded representation
    encoder = Model(input_img, encoded)

    # create a placeholder for an encoded (32-dimensional) input
    encoded_input = Input(shape=(encoding_dim,))
    # retrieve the last layer of the autoencoder model
    decoder_layer = autoencoder.layers[-1]
    # create the decoder model
    decoder = Model(encoded_input, decoder_layer(encoded_input))

    opt = optimizers.Adam(learning_rate=0.07)
    autoencoder.compile(optimizer=opt, loss='binary_crossentropy')

    from keras.datasets import mnist
    import numpy as np
    (x_train, _), (x_test, labels) = mnist.load_data()

    x_train = x_train.astype('float32') / 255.
    x_test = x_test.astype('float32') / 255.
    x_train = x_train.reshape((len(x_train), np.prod(x_train.shape[1:])))
    x_test = x_test.reshape((len(x_test), np.prod(x_test.shape[1:])))
    print (x_train.shape)
    print (x_test.shape)

    autoencoder.fit(x_train, x_train,
                    epochs=100,
                    batch_size=300,
                    shuffle=True,
                    validation_data=(x_test, x_test))

    # encode and decode some digits
    # note that we take them from the *test* set
    encoded_imgs = encoder.predict(x_test)
    decoded_imgs = decoder.predict(encoded_imgs)

    # use Matplotlib (don't ask)
    import matplotlib.pyplot as plt

    n = 10  # how many digits we will display
    plt.figure(figsize=(20, 4))
    for i in range(n):
        # display original
        ax = plt.subplot(2, n, i + 1)
        plt.imshow(x_test[i].reshape(28, 28))
        plt.gray()
        ax.get_xaxis().set_visible(False)
        ax.get_yaxis().set_visible(False)

        # display reconstruction
        ax = plt.subplot(2, n, i + 1 + n)
        plt.imshow(decoded_imgs[i].reshape(28, 28))
        plt.gray()
        ax.get_xaxis().set_visible(False)
        ax.get_yaxis().set_visible(False)
    plt.show()

    autoencoder.save('autoencoder_model_saves/autoencoder.h5')
    encoder.save('autoencoder_model_saves/encoder.h5')
    decoder.save('autoencoder_model_saves/decoder.h5')

    # add the encoded dataset to a yaml file
    dataStr = "["
    labelsStr = "["
    encoded_imgs = encoded_imgs.tolist()
    # convert the label data into a multi-dimensional list
    try:
        labels.shape[1]
        print("Labels are already multi-dimensional")
    except:
        labels = labels.tolist()
        # if an exception was thrown above, it means that the labels list is one dimensional, so we need to fix that
        for i in range(len(labels)):
            elementList = []
            for j in range(encoding_dim):
                if (j == labels[i]): # if the label value is equal to this index, make the value of the list at this index 1, and 0 otherwise
                    elementList.append(1.0)
                else:
                    elementList.append(0.0)
            labels[i] = elementList # set this element of the labels list to the element array

    for i in range(len(encoded_imgs)): # start by converting the arrays into strings
        dataStr += str(encoded_imgs[i]) + ","
        labelsStr += str(labels[i]) + ","
    dataStr = dataStr[:-1:] + "]"
    labelsStr = labelsStr[:-1] + "]"

    dataStr = "data: " + dataStr
    labelsStr = "labels: " + labelsStr

    # now that we have converted the data/labels into strings, write those strings to the yaml file
    dataset = dataStr + "\n" + labelsStr
    file = open(r'src/main/java/resources/dataset.yaml', 'w')
    file.write(dataset) # write to the file
    file.close()

else: # invalid response
    print("Invalid response: " + load)
