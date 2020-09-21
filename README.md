# AI_GeneratedMusic
This github repo has all of the code that I used to make AI generated electronic music.  To create this music, I first created an autoencoder neural network using python and tensorflow.  I converted all of the training data (various popular trap songs) into spectograms, and trained the autoencoder neural network to compress the images.  I wrote a custom Java neural network library to train on the compressed spectographs.  One it had trained, I had it generate it's own music!  You can see the .mp3 file of the result in the repo, or on my youtube channel: 
https://www.youtube.com/watch?v=CmkAsDjjGCc

Also in this repo, you can find a MNIST number recognition example to demonstrate the network's capabilities
