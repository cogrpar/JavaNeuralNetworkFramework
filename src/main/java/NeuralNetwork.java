import java.util.Random;
import org.tensorflow.*;
import org.tensorflow.op.Ops;
import org.tensorflow.op.linalg.MatMul;
import java.lang.Math;

public class NeuralNetwork {

        public static int height = 10; // height of each hidden layer
        public static int layers = 10; //number of hidden layers
        public static final double e =  2.7182818284590452; //constant e
        public static double[][] weights; // the array that will store the weights
        public static double[][] biases; // the array that will store the biases

        public static void main(String[] args) {

            double[][] matrix1 = { {1, 2, 2},
                    {2, 1, 3},
                    {2, 3, 1} };

            double[][] matrix2 = { {1, 3, 3},
                    {3, 1, 2},
                    {3, 2, 1} };

            double product[][] = matrix_multiply(matrix1, matrix2);

            // print out the matrix
            for (int i = 0; i < 3; i ++){
                for (int j = 0; j < 3; j++){
                    System.out.print(product[i][j] + " ");
                }
                System.out.print("\n");
            }

            /*
            
            weights = new double[height*height*layers+3]; // there are height^2 weights for each layer, so the total number of weights is (height^2)*layers
            biases = new double[height*layers]; // there is one bias for each neuron, so this array has height*layers elements, as it is the number of neurons
            setup(); //initialize the values of the weights and biases with random numbers
            
            double[] inputs = new double[height]; //initialize the
            
            //start by setting each value to 0
            for (int n = 0; n < height; n++){
                inputs[n] = 0;
            }
     
            inputs[0] = 1;
            inputs[1] = 0;
            inputs[2] = 1;
            inputs[3] = 0;
            /*
            .
            .
            .
            */
            /*
            inputs[height-1] = 1;
            
            train(inputs, inputs, true, 0.01);
            
            double[] outputs = new double[height];
            
            outputs = run_net(inputs);
            
            for (int t = 0; t<height; t++){
                System.out.println(outputs[t]);
            }
            */
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

        /*
        public static void train(double[] input, double[] training, boolean print, double precision){
            
            for (int i = height*height*layers; i > 0; i = i-1){
                
                //get your weight:
                double errors[] = new double[height];
                double errors2[] =  new double[height];
                errors = run_net(input);
                weights[i] = weights[i] + 1;
                errors2 = run_net(input);
                for (int n = 0; n < height; n++){
                    errors[n] = errors2[n] - errors[n];
                }
                
                weights[i] = weights[i] - 1;
                
                double max = errors[0];
		int index = 0;
                //locate the most affected error:
		for (int ii = 0; ii < errors.length; ii++) 
		{
			if (max < Math.abs(errors[ii])) 
			{
				max = Math.abs(errors[ii]);
				index = ii;
			}
                        //System.out.println(errors[ii]);
		}
    
                long maxx = 100000;
                double cur_x = weights[i];
                double next_x = 0;
                int num = 0;
                double gamma = 0.1;
                double desired = training[index];
                
                while(num < maxx){
                    //get output
                    double net2[] = run_net(input);
                    double net = net2[index];
                    
                    next_x = cur_x;
                    cur_x = next_x-(gamma * (net-desired));
                    num++;
                    double dif = Math.abs(next_x - cur_x);
                    next_x = cur_x;
                    weights[i] = next_x;   
                   
                }
                
                //calc the error:
                double error_tot = 0;
                errors = run_net(input);
                for (int o = 0; o < height; o++){
                    error_tot = error_tot + (training[o] - errors[o]);
                }
        
                //print error:
                if (print == true){
                    System.out.println(error_tot);
                }
                
                if (Math.abs(error_tot) <= precision){
                    break;
                }
            }
           
        }*/

        public static double[][] matrix_multiply (double[][] input1, double[][] input2) { // this method multiples two input matrices and returns the resulting matrix
            // start by figuring out the dimensions of the resulting array
            int[] dimensions = new int[2];
            int l1 = input1.length;
            int w1 = input1[0].length;
            int l2 = input2.length;
            int w2 = input2[0].length;

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

            double[][] matrix_layer = new double[height][1]; // declare a new matrix that will be used to pass the layer data into the matrix_multiply method

            for (int i = 0; i < layers; i++){ // loop over all of the layers

                for (int j = 0; j < height; j++){ // convert the layer data array into a matrix
                    matrix_layer[j][0] = layer[j];
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
