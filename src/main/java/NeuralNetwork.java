import java.io.*;
import java.util.*;
import org.tensorflow.*;
import org.tensorflow.op.Ops;
import org.tensorflow.op.linalg.MatMul;
import org.yaml.snakeyaml.Yaml;
import java.lang.Math;

public class NeuralNetwork {

        public final static int height = 32; // height of each hidden layer
        public final static int layers = 2; //number of hidden layers
        public final static double e =  2.7182818284590452; //constant e
        public static double[][] weights; // the array that will store the weights
        public static double[][] matrixWeights = new double[height][height]; // array to store the weights as a matrix
        public static double[][] biases; // the array that will store the biases
        public final static double learning_rate = 0.01;
        public final static int batch_size = 30; // batch size that the network will train on
        public final static int epochs = 80; // number of epochs that the network will train for

        public static void main(String[] args) {
            setup(); // randomly initialize the weights and biases

            EncodeTrainingData generate_data = new EncodeTrainingData("True", "y", "True"); // use the EncodeTrainingData class to generate the compressed training data using the autoencoder python script
            generate_data.run();

            train(true); // run the network while printing out the progress

            // once the network is trained, wait for the script to add an example to the yaml file, and predict that example
            EncodeTrainingData generate_example = new EncodeTrainingData("True", "y", "False"); // use the EncodeTrainingData class to generate the example for the Network to try out
            generate_example.run();

            Dataset example = new Dataset(); // get the example data
            example.init();

            double[] output_activations = run_net(example.data[0])[layers-1]; // now run the network to see what it predicts

            // now that we have the output of the network, find out which output was predicted
            int highest_output_index = 0;
            for (int i = 0; i < 10; i++){
                if (output_activations[i] > output_activations[highest_output_index]){
                    highest_output_index = i;
                }
                System.out.println(output_activations[i]);
            }

            // now that we know the index (which is also the output) we can print that to the user
            System.out.println("\n\n\nThe model predicted that the example input was a " + highest_output_index);

        }
      
        public static void setup(){ // this method is used to initialize the weights and biases for the network to a random number between 1 and 0
            weights = new double[layers][height*height];
            biases = new double[layers][height];

            // init the weights
            for (int i = 0; i < weights.length; i++){
                for (int j = 0; j < weights[0].length; j++) {
                    weights[i][j] = random_number();
                }
            }
            // init the bias
            for (int i = 0; i < biases.length; i++){
                for (int j = 0; j < biases[0].length; j++) {
                    biases[i][j] = random_number();
                }
            }
        }

        public static void train(boolean print) {

            // fetch the training data and label data
            Dataset data = new Dataset();
            data.init();

            double networkCost = 0; // this variable will store the cost at the end of each epoch

            // the training process will repeat over shuffled data batches, for the number of epochs specified above
            for (int i = 0; i < epochs; i++){
                if (print){
                    System.out.println("epoch " + (i+1) + "/" + epochs); // print some useful information if true was passed into this method
                }

                // start by generating the batch for this epoch
                Random rand = new Random();
                int[] indices = new int[batch_size]; // an array to store the indices of the randomly selected batch
                int index;
                for (int j = 0; j < batch_size; j++){ // for loop to generate the correct number of indices
                    indices[j] = rand.nextInt(data.labels.length - 1); // random index
                }

                // now that we have the batch, we need to calculate the negative gradient of each member of the batch
                double[][][] allNegGradientsWeights = new double[batch_size][weights.length][weights[0].length]; // array to store the gradients for the weights
                double[][][] allNegGradientsBiases = new double[batch_size][biases.length][biases[0].length]; // array to store the gradients for the biases

                // loop over all members of the batches
                for (int j = 0; j < batch_size; j++){

                    // create a new instance of the backpropagation class
                    Backpropagation backpropagation = new Backpropagation(weights, biases, run_net(data.data[indices[j]]), data.labels[indices[j]]);

                    if (print){
                        System.out.println(((double)(j+1) / batch_size) * 100 + "%"); // print the percent done if print is true
                    }

                    backpropagation.calculateGradient(); // calculate the gradient of the cost function

                    // take the weights and biases stored in the instance of backpropagation, make them negative and add them to the arrays storing all gradients for each member of the batch
                    for (int m = 0; m < layers; m++){
                        for (int n = 0; n < height; n++){
                            allNegGradientsBiases[j][m][n] = -1 *backpropagation.negativeGradientBiases[m][n] * learning_rate;

                            for (int k = 0; k < height; k++){
                                allNegGradientsWeights[j][m][n*height+k] = -1 * backpropagation.negativeGradientWeights[m][n*height+k] * learning_rate;
                            }
                        }
                    }

                    if (j == batch_size - 1){ // if this is the last iteration of this loop, calculate the cost for reference
                        networkCost = cost(run_net(data.data[indices[j]])[layers-1], data.labels[indices[j]]);
                    }
                }

                // now that we have a negative gradient for each member of the batch, we need to average them all together
                double[][] averageGradientWeights = new double[weights.length][weights[0].length]; // array to store the average gradient for the weights
                double[][] averageGradientBiases = new double[biases.length][biases[0].length]; // array to store the average gradient for the biases
                double average = 0; // double to store the average for each individual step
                // average the weights
                for (int m = 0; m < weights.length; m++){
                    for (int n = 0; n < weights[0].length; n++){
                        for (int j = 0; j < batch_size; j++) {
                            average += allNegGradientsWeights[j][m][n];
                        }
                        average = average / batch_size; // compute the average
                        averageGradientWeights[m][n] = average;
                        average = 0;
                    }
                }

                // average the biases
                for (int m = 0; m < biases.length; m++){
                    for (int n = 0; n < biases[0].length; n++){
                        for (int j = 0; j < batch_size; j++) {
                            average += allNegGradientsBiases[j][m][n];
                        }
                        average = average / batch_size; // compute the average
                        averageGradientBiases[m][n] = average;
                        average = 0;
                    }
                }

                // we now have the negative gradient biases for this batch, so we need to adjust all of the weights and biases by this negative gradient
                for (int m = 0; m < weights.length; m++){
                    for (int n = 0; n < weights[0].length; n++){
                        weights[m][n] += averageGradientWeights[m][n]; // adjust the weights
                    }
                }

                for (int m = 0; m < biases.length; m++){
                    for (int n = 0; n < biases[0].length; n++){
                        biases[m][n] += averageGradientBiases[m][n]; // adjust the biases
                    }
                }

                // print the cost if print is true
                if (print){
                    System.out.println("Cost: " + networkCost);
                }
            }
        }

        public static double cost (double[] input, double[] expected){ // method to calculate the cost by summing the square of the difference of each activation between the input and the expected activations
            double total = 0; // double to store the total cost
            for (int i = 0; i < input.length; i++){
                total += Math.pow((input[i] - expected[i]), 2); // update the total
            }
            return total; // return the total cost
        }

        public static double[][] matrix_multiply (double[][] input1, double[][] input2) { // this method multiples two input matrices and returns the resulting matrix

            // start by figuring out the dimensions of the resulting array
            int[] dimensions = new int[2];
            int w1 = input1[0].length;
            int w2 = input2[0].length;
            int l1 = input1.length;
            int l2 = input2.length;

            if (l1 == w2){ // if both the matrices share a common element count in this configuration
                dimensions[0] = l2;
                dimensions[1] = w1;
            }
            else if (l2 == w1){ // else if both matrices share a common element count in this configuration
                dimensions[0] = l1;
                dimensions[1] = w2;
            }
            else { // else if these matrices can not be multiplied because they share no common element count
                throw new ArithmeticException(); // throw an exception
            }

            // declare a new Tensorflow Graph that will be used to carry out the operation
            Graph graph = new Graph();

            // create a new operation to multiply the matrices
            Ops tf = Ops.create(graph);
            Session session = new Session(graph);

            // declare the output matrix
            double[][] product = new double[dimensions[0]][dimensions[1]];

            // cary out the multiplication
            tf.withName("mult").linalg.matMul(tf.withName("A").constant(input1), tf.withName("B").constant(input2));
            product = session.runner().fetch("mult").run().get(0).copyTo(product);

            return product;
        }

        private static double sigmoid (double input){ // this method plugs the input into the sigmoid function and returns the output of that function
            return Math.pow(e, input) / (Math.pow(e, input) + 1);
        }

        public static double[][] run_net (double[] inputs){ // this method runs the network and returns the output of the network

            double layer[] = new double[height]; // define an array that will store the layer values
            double layerArray[][] = new double[layers][height];
            double z[][] = new double[1][height]; // define an array that will store the weighted sum of the previous layer and the bias
            layer = inputs;

            double[][] matrix_layer = new double[1][height]; // declare a new matrix that will be used to pass the layer data into the matrix_multiply method

            for (int i = 0; i < layers; i++){ // loop over all of the layers

                // convert the array storing all of the weights into the correctly arranged matrix
                for (int n = 0; n < height; n++){
                    for (int j = 0; j < height; j++){
                        matrixWeights[n][j] = weights[i][n*height+j];
                    }
                }

                for (int j = 0; j < height; j++){ // convert the layer data array into a matrix
                    matrix_layer[0][j] = layer[j];
                }

                z = matrix_multiply(matrix_layer, matrixWeights); // get the z value (weighted sum of all of the previous outputs)

                for (int j = 0; j < height; j++){
                    layer[j] = sigmoid(z[0][j] + biases[i][j]); //add the bias to the weighted sum and pump the result into the sigmoid function
                }
                layerArray[i] = layer;

            }

            return layerArray;
        }

        public static double random_number(){ //function to generate random decimals
            Random rand = new Random();

            // Obtain a number between [0 - 199].
            double n = rand.nextInt(199);

            n = n/100;
            n = n - 1;
            return n;
        }

}

class Dataset{ // this is the class that the dataset in the yaml file gets mapped to

    public void init() { // when init is run, fetch the data and labels from the yaml file
        File test = new File(".\\src\\main\\java\\resources\\dataset.yaml"); // specify the file
        System.out.println("Can Access YAML File: " + test.canRead());
        System.out.println("Fetching Training Data...");

        try{
            Yaml yaml = new Yaml(); // yaml parser object
            BufferedReader br = new BufferedReader(new FileReader(".\\src\\main\\java\\resources\\dataset.yaml")); // buffer reader to actually read the file
            Map<String, Object> obj = yaml.load(br); // write the yaml entries to a hashmap
            System.out.println("Done!");

            // now write the fetched entries in the hashmap to the array attributes stored in this class
            List<List<Double>> labelsList = (List<List<Double>>) obj.get("labels");
            List<List<Double>> dataList = (List<List<Double>>)obj.get("data");

            labels = new double[labelsList.size()][labelsList.get(0).size()];
            data = new double[dataList.size()][dataList.get(0).size()];

            // now loop over the List and add the data to the corresponding arrays
            for (int i = 0; i < labelsList.size(); i++){
                // add the label at this index to the array, which will require another for loop as it is two dimensional
                for (int j = 0; j < labelsList.get(i).size(); j++){
                    labels[i][j] = Double.valueOf(labelsList.get(i).get(j)).doubleValue();
                }

                // next add the data at this index, which will require another for loop as it is two dimensional
                for (int j = 0; j < dataList.get(i).size(); j++){
                    data[i][j] = Double.valueOf(dataList.get(i).get(j)).doubleValue();
                }
            }

        }catch(Exception e){System.out.println("error reading dataset: " + e);}

    }

    double[][] labels;
    double[][] data;

}

class Backpropagation{ // this class has all of the tools for carrying out the calculus needed for backpropagation

    public final static double e =  2.7182818284590452; //constant e
    double weights[][];
    double biases[][];
    double layerArray[][];
    double negativeGradientWeights[][];
    double negativeGradientBiases[][];
    double expectedOutput[];

    public Backpropagation (double[][] weights, double[][] biases, double[][] layerArray, double[] expextedOutput){ // pass the values of the weights biases and the network into this class from main
        this.weights = weights;
        this.biases = biases;
        this.layerArray = layerArray;
        this.expectedOutput = expextedOutput;
    }

    private static double sigmoid (double input){ // this method plugs the input into the sigmoid function and returns the output of that function
        return Math.pow(e, input) / (Math.pow(e, input) + 1);
    }

    public double derivative (String x, int indexX1, int indexX2, String y, int indexY1, int indexY2, double expectedValue){ // this method handles all derivatives (returns dy/dx)

        // if the arguments are dz/dw
        if (x == "w" && y == "z"){
            return layerArray[indexX1][indexX2];  // return the activation of the previous layer (ak(L-1)) where index1 is the previous layer (L-1) and index2 is the activation on that layer (k)
        }

        // if the arguments are da/dz
        else if (x == "z" && y == "a"){
            double z = biases[indexX1+1][indexX2]; // calculate the value of z where indexX1 is the layer and indexX2 is the position within that layer
            for (int i = 0; i < layerArray[0].length; i++){
                z += layerArray[indexX1][i] * weights[indexX1+1][indexX2*layerArray[0].length+i];
            }
            return sigmoid(z) * (1 - sigmoid(z));
        }

        // if the arguments are dc/da
        else if (x == "a" && y == "c"){
            return 2 *(layerArray[indexX1][indexX2] - expectedValue); // where indexX1 is the layer and and indexX2 is the position within that layer
        }

        // if the arguments are dz/db
        else if (x == "b" && y == "z"){
            return 1;
        }

        // if the arguments are dz/da
        else if (x == "a" && y == "z"){
            return weights[indexX1][indexY1*layerArray[0].length+indexX2]; // where indexX1 is the layer and indexX2 is the position within the previous and indexY1 is the position within this layer
        }

        else{
            throw new ArithmeticException(); // if the input was not a recognised derivative, throw an arithmetic error
        }
    }

    public void calculateGradient (){ // when this method is called, it will calculate the gradient of all of the weights and biases, and return them

        double gradient; // this double stores the temporary value of the gradient as it is being calculated and before it is appended to the gradient array
        negativeGradientWeights = new double[weights.length][weights[0].length]; // initialize the dimensions of the weight and bias gradient arrays
        negativeGradientBiases = new double[biases.length][biases[0].length];

        // the method loops over each layer, moving backwards as it goes
        for (int i = 1 /* number of layers */; i < weights.length-1; i++){

            // the first thing that happens at each iteration is the calculation of the gradient of all of the weights in this layer
            // the gradient for a weight is calculated using (dc)/(dw) = (dz/dw)(da/dz)(dc/da)
            for (int m = 0; m < expectedOutput.length; m++){
                for (int n = 0; n < expectedOutput.length; n++){
                    // these loop over all weights in a given layer
                    // calculate the gradient
                    gradient = derivative("w", 0, 0, "z", 0, 0, 0) * derivative("z", i, n, "a", 0, 0, 0) * derivative("a", i, n, "c", 0, 0, expectedOutput[m]);

                    // add the gradient to the array
                    negativeGradientWeights[i][expectedOutput.length*m+n] = gradient;
                }
            }

            // next the gradients for the biases are calculated
            // the gradient for a bias is calculated by using (dc)/(db) = (dz/db)(da/dz)(dc/da)
            for (int m = 0; m < expectedOutput.length; m++){
                // these loop over all biases in a given layer
                // calculate the gradient
                gradient = derivative("b", i-1, m, "z", 0, 0, 0) * derivative("z", i, m, "a", 0, 0, 0) * derivative("a", i, m, "c", 0, 0, expectedOutput[m]);

                // add the gradient to the array
                negativeGradientWeights[i][m] = gradient;

            }

            // finally, the gradients for the previous activations are calculated
            double[] deltaActivations = expectedOutput; // this is the place where temporary store how the previous activations should be changes before they are written to the actual array used in calculations
            // loop over all of the previous layer's activations
            for (int m = 0; m < expectedOutput.length; m++){
                // these are more complicated, so they need to be summed over all of the outputs
                int sum = 0;

                // the gradient for a bias is calculated by using (dc)/(da) = sum over the activations((dz/da)(da/dz)(dc/da))
                for (int n = 0; n < expectedOutput.length; n++){
                    sum += derivative("a", i, m, "z", n, 0, 0) * derivative("z", i, m, "a", 0, 0, 0) * derivative("a", i, m, "c", 0, 0, expectedOutput[m]);
                }

                // adjust the activations by this amount
                deltaActivations[m] -= sum;
            }

        }
    }

}

class EncodeTrainingData{ // this class runs the python script that implements a tensorflow autoencoder to compress the training data to the correct dimensions to be fed into the java neural network
        String user_input;
        String load;
        String generate_training_data;

        public EncodeTrainingData (String user_input, String load, String generate_training_data){ // constructor
            this.user_input = user_input;
            this.load = load;
            this.generate_training_data = generate_training_data;
        }

        public void run (){
        // execute the python script
        System.out.print("compressing input...\n");
        try {
            Process process = Runtime.getRuntime().exec("python autoencoder.py " + load + " " + user_input + " " + generate_training_data);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            //int wait = process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
