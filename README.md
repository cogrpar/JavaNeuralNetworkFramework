This repo has all the code that I used to create a very basic neural network framework in Java. The network parameters are stored in arrays, and the training algorithm implements gradient descent using TensorFlow Java for the derivatives. This project was part of my experience in understanding the inner workings of a neural network.

As an initial test of the model, I implemented written digit classification using the MNIST database. Because of the limitations of the models created within this framework, I created an autoencoder neural network using python and Keras/TensorFlow to compress the handwritten digits into a smaller number of dimensions for classification.

As a more ambitious test, I attempted to use this framework to generate music. To create this music, I once again implemented an autoencoder. I converted all the training data (some random electronic music from YouTube) into spectrograms, and trained the autoencoder neural network to compress the images. These compressed spectrograms were then used by the Java neural network as training examples to generate a unique "song". You can see the .mp3 file of the result in the repo, or on my YouTube channel: https://www.youtube.com/watch?v=CmkAsDjjGCc

While the results of both of these tests were mixed, I did find that the models were able to reduce loss to a certain extent, and I learned a lot about neural networks in the process.

