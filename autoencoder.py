# this code is an autoencoder to help optimize the Java Neural Network by compressing the inputs to the size of the Java network height

from keras.layers import Input, Dense
from keras.models import Model
from keras import optimizers
from keras import regularizers
from tensorflow import keras
from keras.datasets import mnist
import numpy as np
import matplotlib.pyplot as plt
from PIL import Image, ImageOps
import sys
from time import sleep

# import the draw class to allow the user to draw numbers for the network to predict
sys.path.append('./MNIST Example/')
from drawingPad import DrawingPad

# look at the arguments to see if we want to load from the model
arguments = sys.argv
load = arguments[1] # the first command line argument is the load boolean that determines if the model will be loaded from pre trained files
user_in = arguments[2] # the second command line argument is the boolean that determines if the model will run based on the user drawn digit
generate_training_data = arguments[3] # the third command line argument is the boolean that determines if this program should generate all of the training data (True), or only a single example (False)

# convert user in and generate training data to booleans
if (user_in == "True"):
    user_in = True
else:
    user_in = False

if (generate_training_data == "True"):
    generate_training_data = True
else:
    generate_training_data = False

# this is the size of our encoded activations
encoding_dim = 32  # 10 floats

(x_train, _), (x_test, labels) = mnist.load_data()  # get the MNIST digits


class EncoderTools:  # this class stores methods for running the autoencoder (once it has already been trained) and some methods for displaying the autoencoder's accuracy on a set of examples

    def __init__(self, encoder, decoder, x_test, x_train, labels):
        self.encoder = encoder
        self.decoder = decoder
        self.x_test = x_test
        self.x_train = x_train
        self.labels = labels

    def run_encoder(self):  # this method runs the encoder on the MNIST dataset
        encoder = self.encoder
        decoder = self.decoder
        x_test = self.x_test
        x_train = self.x_train
        labels = self.labels

        # reformat the data correctly
        x_train = x_train.astype('float32') / 255.
        x_test = x_test.astype('float32') / 255.
        x_train = x_train.reshape((len(x_train), np.prod(x_train.shape[1:])))
        x_test = x_test.reshape((len(x_test), np.prod(x_test.shape[1:])))

        # encode and decode the digits
        encoded_imgs = encoder.predict(x_test)
        decoded_imgs = decoder.predict(encoded_imgs)
        return encoded_imgs, decoded_imgs

    def send_new_example(self, user_input):  # now that the autoencoder has trained / been loaded, send a new example to the network to see how it does
        encoder = self.encoder
        decoder = self.decoder
        x_test = self.x_test
        x_train = self.x_train
        labels = self.labels

        # check to see if user input should be loaded, or if a random MNIST element should be used instead
        if (user_input):
            # get the image drawn by the user
            DrawingPad()
            drawing = Image.open("./MNIST Example/user_drawn_image_to_scale.png")
            drawing = ImageOps.grayscale(drawing)
            pixel_values = list(drawing.getdata())  # convert the image into an array

        else:
            # get a random element of the MNIST database
            import random
            pixel_values = x_test[random.randint(0, 9)].tolist()

        # now show the image so the user can see it for reference
        Image.fromarray(np.asarray(pixel_values).reshape(28, 28)).show()

        pixel_values = [pixel_values]
        pixel_values = np.asarray(pixel_values).reshape(1, 784)
        print("Example Shape: ")
        print(np.asarray(pixel_values).shape)

        # send the image through the encoder to compress it to the desired height
        compressed_image = encoder.predict(pixel_values)
        # send the resulting outputs through a sigmoid function so that they will fit through the java network
        for i in compressed_image:
            i = 1 / (1 + math.exp(-i))

        # send this example to the yaml file so the Java ANN can load it and predict a number with it
        data = "data: [["
        activations_data = ""
        label_data = ""
        for i in range(encoding_dim):
            activations_data += "{:.2f}".format(compressed_image[0][i]) + ", "
        activations_data = activations_data[:-2:]
        data += activations_data + "], [" + activations_data + "]]\nlabels: [["  # we must add two instances of the activation and label data so that the java program does not throw an error
        for i in range(encoding_dim):
            label_data += "0.0, "
        label_data = label_data[:-2:]
        data += label_data + "], [" + label_data + "]]"  # we must add two instances of the activation and label data so that the java program does not throw an error

        # now that we have converted the data/labels into strings, write those strings to the yaml file
        file = open(r'src/main/java/resources/dataset.yaml', 'w')
        file.write(data)  # write to the file
        file.close()

    def show_network_performance(self, decoded_imgs):  # this method displays a set of encoded and decoded images so the user can see how accurate the network is
        encoder = self.encoder
        decoder = self.decoder
        x_test = self.x_test
        x_train = self.x_train
        labels = self.labels

        # use Matplotlib to display the images
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

    def send_to_yaml(self, encoded_imgs):  # this method sends the compressed dataset to a yaml file so it can be read by the Java Neural Network
        encoder = self.encoder
        decoder = self.decoder
        x_test = self.x_test
        x_train = self.x_train
        labels = self.labels

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
                    if (j == labels[i]):  # if the label value is equal to this index, make the value of the list at this index 1, and 0 otherwise
                        elementList.append(1.0)
                    else:
                        elementList.append(0.0)
                labels[i] = elementList  # set this element of the labels list to the element array

        for i in range(len(encoded_imgs)):  # start by converting the arrays into strings
            dataStr += str(encoded_imgs[i]) + ","
            labelsStr += str(labels[i]) + ","
        dataStr = dataStr[:-1:] + "]"
        labelsStr = labelsStr[:-1] + "]"

        dataStr = "data: " + dataStr
        labelsStr = "labels: " + labelsStr

        # now that we have converted the data/labels into strings, write those strings to the yaml file
        dataset = dataStr + "\n" + labelsStr
        file = open(r'src/main/java/resources/dataset.yaml', 'w')
        file.write(dataset)  # write to the file
        file.close()


# main
if (generate_training_data): # if this script was run with the argument to generate all training data for the Java Neural Network
    if (load == 'y'): # if they answer yes
        print("loading model...\n")
        autoencoder = keras.models.load_model('autoencoder_model_saves/autoencoder.h5') # load the models
        encoder = keras.models.load_model('autoencoder_model_saves/encoder.h5')
        decoder = keras.models.load_model('autoencoder_model_saves/decoder.h5')
        print("Done")

        tools = EncoderTools(encoder, decoder, x_test, x_train, labels) # create a new instance of the encoder tools class

        encoded_imgs, decoded_imgs = tools.run_encoder() # execute the method to encode and decode the dataset
        tools.show_network_performance(decoded_imgs) # display the network performance to the user
        tools.send_to_yaml(encoded_imgs) # add the encoded dataset to the yaml file to the Java Neural Network can use it as training data

        sleep(3) # pause to let the yaml file update


    elif (load == 'n'): # if they answer no

        # this is our input placeholder
        input_img = Input(shape=(784,))
        # "encoded" is the encoded representation of the input
        encoded = Dense(encoding_dim, activation='relu')(input_img)
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

        #opt = optimizers.Adadelta(learning_rate=0.1)
        # noinspection PyInterpreter
        autoencoder.compile(optimizer="adadelta", loss='binary_crossentropy')

        x_train = x_train.astype('float32') / 255.
        x_test = x_test.astype('float32') / 255.
        x_train = x_train.reshape((len(x_train), np.prod(x_train.shape[1:])))
        x_test = x_test.reshape((len(x_test), np.prod(x_test.shape[1:])))
        print (x_train.shape)
        print (x_test.shape)

        autoencoder.fit(x_train, x_train,
                        epochs=1000,
                        batch_size=131,
                        shuffle=True,
                        validation_data=(x_test, x_test))

        tools = EncoderTools(encoder, decoder, x_test, x_train, labels)  # create a new instance of the encoder tools class

        encoded_imgs, decoded_imgs = tools.run_encoder()  # execute the method to encode and decode the dataset
        tools.show_network_performance(decoded_imgs)  # display the network performance to the user
        tools.send_to_yaml(encoded_imgs)  # add the encoded dataset to the yaml file to the Java Neural Network can use it as training data

        autoencoder.save('autoencoder_model_saves/autoencoder.h5')
        encoder.save('autoencoder_model_saves/encoder.h5')
        decoder.save('autoencoder_model_saves/decoder.h5')

        sleep(3) # pause to let the yaml file update

    else: # invalid response
        print("Invalid response: " + load)

elif (not generate_training_data): # if the script was not run with the argument to generate all training data, generate a single example for the Java Network to predict
    print("loading model to compress example...\n")
    autoencoder = keras.models.load_model('autoencoder_model_saves/autoencoder.h5')  # load the models
    encoder = keras.models.load_model('autoencoder_model_saves/encoder.h5')
    decoder = keras.models.load_model('autoencoder_model_saves/decoder.h5')
    print("Done")

    tools = EncoderTools(encoder, decoder, x_test, x_train, labels)  # create a new instance of the encoder tools class
    tools.send_new_example(user_in) # send a new example to the Network

    sleep(3) # pause to let the yaml file update
