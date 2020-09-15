import java.io.*;
import java.nio.DoubleBuffer;
import java.util.*;

import org.tensorflow.*;
import org.tensorflow.op.Ops;
import org.tensorflow.op.linalg.MatMul;
import org.yaml.snakeyaml.Yaml;
import java.lang.Math;

public class NeuralNetwork {

        public final static int height = 10; // height of each hidden layer
        public final static int layers = 10; //number of hidden layers
        public static final double e =  2.7182818284590452; //constant e
        public static double[][] weights; // the array that will store the weights
        public static double[][] biases; // the array that will store the biases
        public final static double learning_rate = 0.1;
        public final static int batch_size = 10;

        public static void main(String[] args) {
            train(false);
/*
            setup();

            double[] input = new double[height];
            for (int i = 0; i < height; i++){
                input[i] = random_number();

                if (input[i] < 0){
                    input[i] = 0;
                }
            }

            double [] run = run_net(input);
            for (int i = 0; i < height; i++){
                System.out.println(run[i]);
            }
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
            }*/
        }

        public static void train(boolean print) {

            Dataset data = new Dataset();
            data.init();

        }

        public static double[][] matrix_multiply (double[][] input1, double[][] input2) { // this method multiples two input matrices and returns the resulting matrix
            System.out.println(Arrays.toString(input2));

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

        public static double sigmoid (double input){ // this method plugs the input into the sigmoid function and returns the output of that function
            return Math.pow(e, input) / (Math.pow(e, input) + 1);
        }
        
        public static double[] run_net (double[] inputs){ // this method runs the network and returns the output of the network

            double layer[] = new double[height]; // define an array that will store the layer values
            double z[][] = new double[1][height]; // define an array that will store the weighted sum of the previous layer and the bias
            layer = inputs;

            double[][] matrix_layer = new double[1][height]; // declare a new matrix that will be used to pass the layer data into the matrix_multiply method

            for (int i = 0; i < layers; i++){ // loop over all of the layers

                for (int j = 0; j < height; j++){ // convert the layer data array into a matrix
                    matrix_layer[0][j] = layer[j];
                }

                z = matrix_multiply(matrix_layer, weights); // get the z value (weighted sum of all of the previous outputs)

                for (int j = 0; j < height; j++){
                    layer[j] = sigmoid(z[0][j] + biases[i][j]); //add the bias to the weighted sum and pump the result into the sigmoid function
                }
                //System.out.println(layer[j][i]);
            }

            return layer;
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
