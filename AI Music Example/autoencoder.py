
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

import pickle

import warnings
warnings.filterwarnings('ignore')

import tensorflow
import keras
from keras.layers import Input, Dense
from keras.models import Model
import numpy as np
from PIL import Image
from keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt
import os

dir = '/home/pi/Downloads/neural-network-master/data/data/'
master = []
testdir = '/home/pi/Downloads/neural-network-master/data/train/class_a/class_1/'
trainmaster = []

for img in os.listdir(dir):
	image = Image.open(dir+img)
	image.load()
	data = np.asarray( image, dtype='uint8' )
	print (data.shape)
	master.append(data)	 

for img in os.listdir(testdir):
        image = Image.open(dir+img)
        image.load()
        data = np.asarray( image, dtype='uint8' )
        print (data.shape)
        trainmaster.append(data)      



(x_train) = master
(x_test) = trainmaster

x_train = np.array(x_train).reshape(-1, 28, 28, 1)
x_test = np.array(x_test).reshape(-1, 28, 28, 1)

x_train = x_train.astype('float32') / 255
x_test = x_test.astype('float32') / 255

print(x_train)
print(x_test)


encoding_dim = 32

input_img = Input(shape=(784,))

encoded = Dense(encoding_dim, activation='relu')(input_img)

decoded = Dense(784, activation='sigmoid')(encoded)

autoencoder = Model(input_img, decoded)
encoder = Model(input_img, encoded)

encoded_input = Input(shape=(encoding_dim,))
decoded_layer = autoencoder.layers[-1]
decoder = Model(encoded_input, decoded_layer(encoded_input))

autoencoder.compile(optimizer='adadelta', loss='binary_crossentropy')

x_train = x_train.reshape((len(x_train), np.prod(x_train.shape[1:])))
x_test = x_test.reshape((len(x_test), np.prod(x_test.shape[1:])))

print (x_train.shape)
print(x_test.shape)

autoencoder.fit(x_train, x_train,
	epochs=1000,
	batch_size=131,
	shuffle=True,
	validation_data=(x_test, x_test))

encoded_imgs = encoder.predict(x_test)
print(encoded_imgs.shape)

for i in range(32):
	print('test[', i, '] = ', encoded_imgs[0, i])
	
for i in range(32):
        print('test[', 32+i, '] = ', encoded_imgs[1, i])
	
for i in range(32):
        print('test[', 64+i, '] = ', encoded_imgs[2, i])
	
decoded_imgs = decoder.predict(encoded_imgs)

plt.imshow(x_test[0].reshape(28, 28))
plt.gray()
plt.show()

plt.imshow(decoded_imgs[0].reshape(28, 28))
plt.gray()
plt.show()

