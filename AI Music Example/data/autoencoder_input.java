package autoencoder_inputs;

import java.util.Random;

public class Autoencoder_inputs {
    
        public static int height = 96;
        public static int layers = 50;
        public static double e =  2.7182818284590452;
        public static double[] weights;

        public static void main(String[] args) {
            
            weights = new double[height*height*layers+3];
            weights = setup();
            
            double[] inputs = new double[height];
            
            //start by setting each value to 1
            for (int n = 0; n < height; n++){
                inputs[n] = 1;
            }
            
            int num_of_train = 10;
            System.out.println("Starting...");
     
            double[][] training = new double[num_of_train][height];
            //set the values of training right here:
            //...
            training[0][ 0 ] =  0.19599748;
            training[0][ 1 ] =  0.0;
            training[0][ 2 ] =  0.0;
            training[0][ 3 ] =  0.78626394;
            training[0][ 4 ] =  0.358055;
            training[0][ 5 ] =  0.61432743;
            training[0][ 6 ] =  0.0;
            training[0][ 7 ] =  0.0;
            training[0][ 8 ] =  0.0;
            training[0][ 9 ] =  0.0;
            training[0][ 10 ] =  0.24464753;
            training[0][ 11 ] =  0.0;
            training[0][ 12 ] =  0.0;
            training[0][ 13 ] =  1.6429505;
            training[0][ 14 ] =  0.11605394;
            training[0][ 15 ] =  0.0;
            training[0][ 16 ] =  0.92686397;
            training[0][ 17 ] =  1.9690541;
            training[0][ 18 ] =  0.94740653;
            training[0][ 19 ] =  1.1184592;
            training[0][ 20 ] =  0.0;
            training[0][ 21 ] =  0.0;
            training[0][ 22 ] =  2.4323614;
            training[0][ 23 ] =  1.1971267;
            training[0][ 24 ] =  0.0;
            training[0][ 25 ] =  0.53294826;
            training[0][ 26 ] =  2.514844;
            training[0][ 27 ] =  2.3552973;
            training[0][ 28 ] =  0.0;
            training[0][ 29 ] =  2.949084;
            training[0][ 30 ] =  0.0;
            training[0][ 31 ] =  1.0382521;
            training[0][ 32 ] =  0.55146945;
            training[0][ 33 ] =  0.0;
            training[0][ 34 ] =  0.0;
            training[0][ 35 ] =  0.35524654;
            training[0][ 36 ] =  0.0;
            training[0][ 37 ] =  0.5421135;
            training[0][ 38 ] =  0.0;
            training[0][ 39 ] =  0.0;
            training[0][ 40 ] =  0.0;
            training[0][ 41 ] =  0.0;
            training[0][ 42 ] =  0.5008888;
            training[0][ 43 ] =  0.6389437;
            training[0][ 44 ] =  0.0;
            training[0][ 45 ] =  1.674246;
            training[0][ 46 ] =  1.336958;
            training[0][ 47 ] =  0.0;
            training[0][ 48 ] =  0.42493117;
            training[0][ 49 ] =  1.6202114;
            training[0][ 50 ] =  0.75180435;
            training[0][ 51 ] =  1.5426235;
            training[0][ 52 ] =  0.0;
            training[0][ 53 ] =  0.0;
            training[0][ 54 ] =  1.9590834;
            training[0][ 55 ] =  1.8596251;
            training[0][ 56 ] =  0.0;
            training[0][ 57 ] =  0.22997347;
            training[0][ 58 ] =  2.3987355;
            training[0][ 59 ] =  2.1505141;
            training[0][ 60 ] =  0.0;
            training[0][ 61 ] =  1.5571076;
            training[0][ 62 ] =  0.0;
            training[0][ 63 ] =  0.3743024;
            training[0][ 64 ] =  0.0;
            training[0][ 65 ] =  0.0;
            training[0][ 66 ] =  0.0;
            training[0][ 67 ] =  0.0;
            training[0][ 68 ] =  0.0;
            training[0][ 69 ] =  0.0;
            training[0][ 70 ] =  0.0;
            training[0][ 71 ] =  0.0;
            training[0][ 72 ] =  0.0;
            training[0][ 73 ] =  0.0;
            training[0][ 74 ] =  3.2374585;
            training[0][ 75 ] =  0.33298275;
            training[0][ 76 ] =  0.0;
            training[0][ 77 ] =  0.09630406;
            training[0][ 78 ] =  0.0;
            training[0][ 79 ] =  0.0;
            training[0][ 80 ] =  0.23333183;
            training[0][ 81 ] =  0.0;
            training[0][ 82 ] =  0.7003182;
            training[0][ 83 ] =  0.0;
            training[0][ 84 ] =  0.0;
            training[0][ 85 ] =  0.0;
            training[0][ 86 ] =  3.6872742;
            training[0][ 87 ] =  0.880013;
            training[0][ 88 ] =  0.0;
            training[0][ 89 ] =  1.4517391;
            training[0][ 90 ] =  0.5658026;
            training[0][ 91 ] =  1.8375239;
            training[0][ 92 ] =  0.0;
            training[0][ 93 ] =  2.5850616;
            training[0][ 94 ] =  0.0;
            training[0][ 95 ] =  0.33033442;
            training[1][ 0 ] =  0.0;
            training[1][ 1 ] =  0.0;
            training[1][ 2 ] =  0.0;
            training[1][ 3 ] =  0.76830626;
            training[1][ 4 ] =  0.029274225;
            training[1][ 5 ] =  0.15952021;
            training[1][ 6 ] =  0.0;
            training[1][ 7 ] =  0.0;
            training[1][ 8 ] =  0.0;
            training[1][ 9 ] =  0.0;
            training[1][ 10 ] =  0.07445004;
            training[1][ 11 ] =  0.0;
            training[1][ 12 ] =  0.0;
            training[1][ 13 ] =  1.4011813;
            training[1][ 14 ] =  0.0;
            training[1][ 15 ] =  0.0;
            training[1][ 16 ] =  0.6740373;
            training[1][ 17 ] =  1.4924763;
            training[1][ 18 ] =  0.52908593;
            training[1][ 19 ] =  1.1761117;
            training[1][ 20 ] =  0.0;
            training[1][ 21 ] =  0.0;
            training[1][ 22 ] =  3.3300085;
            training[1][ 23 ] =  1.8026208;
            training[1][ 24 ] =  0.0;
            training[1][ 25 ] =  0.44974548;
            training[1][ 26 ] =  2.2233782;
            training[1][ 27 ] =  3.106435;
            training[1][ 28 ] =  0.0;
            training[1][ 29 ] =  2.4948325;
            training[1][ 30 ] =  0.0;
            training[1][ 31 ] =  1.0724303;
            training[1][ 32 ] =  0.36915702;
            training[1][ 33 ] =  0.0;
            training[1][ 34 ] =  0.0;
            training[1][ 35 ] =  0.40678024;
            training[1][ 36 ] =  0.0;
            training[1][ 37 ] =  0.9172284;
            training[1][ 38 ] =  0.0;
            training[1][ 39 ] =  0.0;
            training[1][ 40 ] =  0.0;
            training[1][ 41 ] =  0.0;
            training[1][ 42 ] =  1.7080134;
            training[1][ 43 ] =  0.7678571;
            training[1][ 44 ] =  0.0;
            training[1][ 45 ] =  1.4638903;
            training[1][ 46 ] =  1.3058349;
            training[1][ 47 ] =  0.0;
            training[1][ 48 ] =  0.44023424;
            training[1][ 49 ] =  1.3862967;
            training[1][ 50 ] =  0.9601307;
            training[1][ 51 ] =  1.1536608;
            training[1][ 52 ] =  0.0;
            training[1][ 53 ] =  0.0;
            training[1][ 54 ] =  1.4556047;
            training[1][ 55 ] =  1.2553295;
            training[1][ 56 ] =  0.0;
            training[1][ 57 ] =  0.51081175;
            training[1][ 58 ] =  1.9658213;
            training[1][ 59 ] =  1.9413738;
            training[1][ 60 ] =  0.0;
            training[1][ 61 ] =  2.1031778;
            training[1][ 62 ] =  0.0;
            training[1][ 63 ] =  0.8907339;
            training[1][ 64 ] =  1.3903952;
            training[1][ 65 ] =  0.0;
            training[1][ 66 ] =  0.2502458;
            training[1][ 67 ] =  1.695853;
            training[1][ 68 ] =  0.91240513;
            training[1][ 69 ] =  1.5741606;
            training[1][ 70 ] =  0.0;
            training[1][ 71 ] =  0.0;
            training[1][ 72 ] =  0.0;
            training[1][ 73 ] =  0.0;
            training[1][ 74 ] =  1.419775;
            training[1][ 75 ] =  1.2445148;
            training[1][ 76 ] =  0.0;
            training[1][ 77 ] =  2.0627768;
            training[1][ 78 ] =  2.7739592;
            training[1][ 79 ] =  0.0;
            training[1][ 80 ] =  0.074238926;
            training[1][ 81 ] =  2.574122;
            training[1][ 82 ] =  0.82936126;
            training[1][ 83 ] =  2.7429743;
            training[1][ 84 ] =  0.0;
            training[1][ 85 ] =  0.5846424;
            training[1][ 86 ] =  0.17156434;
            training[1][ 87 ] =  1.6465724;
            training[1][ 88 ] =  0.0;
            training[1][ 89 ] =  0.06819458;
            training[1][ 90 ] =  2.3644469;
            training[1][ 91 ] =  2.7305937;
            training[1][ 92 ] =  0.0;
            training[1][ 93 ] =  1.8720617;
            training[1][ 94 ] =  0.0;
            training[1][ 95 ] =  0.8592468;
            training[2][ 0 ] =  0.0;
            training[2][ 1 ] =  0.0;
            training[2][ 2 ] =  0.0;
            training[2][ 3 ] =  0.7871735;
            training[2][ 4 ] =  0.0;
            training[2][ 5 ] =  0.20313895;
            training[2][ 6 ] =  0.0;
            training[2][ 7 ] =  0.0;
            training[2][ 8 ] =  0.0;
            training[2][ 9 ] =  0.0;
            training[2][ 10 ] =  0.6256635;
            training[2][ 11 ] =  0.17643985;
            training[2][ 12 ] =  0.0;
            training[2][ 13 ] =  1.2431767;
            training[2][ 14 ] =  0.010138869;
            training[2][ 15 ] =  0.0;
            training[2][ 16 ] =  0.6335717;
            training[2][ 17 ] =  1.5317345;
            training[2][ 18 ] =  0.4354951;
            training[2][ 19 ] =  1.1079574;
            training[2][ 20 ] =  0.0;
            training[2][ 21 ] =  0.0;
            training[2][ 22 ] =  3.2773585;
            training[2][ 23 ] =  1.7432277;
            training[2][ 24 ] =  0.0;
            training[2][ 25 ] =  0.46704668;
            training[2][ 26 ] =  1.9168451;
            training[2][ 27 ] =  3.017709;
            training[2][ 28 ] =  0.0;
            training[2][ 29 ] =  2.2593408;
            training[2][ 30 ] =  0.0;
            training[2][ 31 ] =  1.0123687;
            training[2][ 32 ] =  0.19617438;
            training[2][ 33 ] =  0.0;
            training[2][ 34 ] =  0.0;
            training[2][ 35 ] =  0.0054318905;
            training[2][ 36 ] =  0.0;
            training[2][ 37 ] =  0.55425733;
            training[2][ 38 ] =  0.0;
            training[2][ 39 ] =  0.0;
            training[2][ 40 ] =  0.0;
            training[2][ 41 ] =  0.0;
            training[2][ 42 ] =  1.0425916;
            training[2][ 43 ] =  0.6839975;
            training[2][ 44 ] =  0.0;
            training[2][ 45 ] =  1.7350309;
            training[2][ 46 ] =  1.0329398;
            training[2][ 47 ] =  0.0;
            training[2][ 48 ] =  0.73834;
            training[2][ 49 ] =  1.4782132;
            training[2][ 50 ] =  0.9984645;
            training[2][ 51 ] =  0.8277502;
            training[2][ 52 ] =  0.0;
            training[2][ 53 ] =  0.0;
            training[2][ 54 ] =  1.8738863;
            training[2][ 55 ] =  1.6408322;
            training[2][ 56 ] =  0.0;
            training[2][ 57 ] =  0.5092326;
            training[2][ 58 ] =  1.9585748;
            training[2][ 59 ] =  1.6621859;
            training[2][ 60 ] =  0.0;
            training[2][ 61 ] =  1.7630236;
            training[2][ 62 ] =  0.0;
            training[2][ 63 ] =  0.6403208;
            training[2][ 64 ] =  1.2646418;
            training[2][ 65 ] =  0.015644008;
            training[2][ 66 ] =  1.0831121;
            training[2][ 67 ] =  2.1165686;
            training[2][ 68 ] =  1.4787362;
            training[2][ 69 ] =  1.0739417;
            training[2][ 70 ] =  0.0;
            training[2][ 71 ] =  0.0;
            training[2][ 72 ] =  0.0;
            training[2][ 73 ] =  0.040385935;
            training[2][ 74 ] =  0.9208743;
            training[2][ 75 ] =  0.6920581;
            training[2][ 76 ] =  0.0;
            training[2][ 77 ] =  1.9123447;
            training[2][ 78 ] =  2.1887777;
            training[2][ 79 ] =  0.0;
            training[2][ 80 ] =  0.08274713;
            training[2][ 81 ] =  2.6947086;
            training[2][ 82 ] =  0.86421454;
            training[2][ 83 ] =  3.1440425;
            training[2][ 84 ] =  0.0;
            training[2][ 85 ] =  1.9558805;
            training[2][ 86 ] =  0.80528116;
            training[2][ 87 ] =  1.59043;
            training[2][ 88 ] =  0.0;
            training[2][ 89 ] =  0.12752691;
            training[2][ 90 ] =  2.6590295;
            training[2][ 91 ] =  3.3651478;
            training[2][ 92 ] =  0.0;
            training[2][ 93 ] =  2.3002424;
            training[2][ 94 ] =  0.0;
            training[2][ 95 ] =  0.91259;
            training[3][ 0 ] =  0.67377335;
            training[3][ 1 ] =  0.0;
            training[3][ 2 ] =  0.0;
            training[3][ 3 ] =  0.0;
            training[3][ 4 ] =  0.0;
            training[3][ 5 ] =  0.8852939;
            training[3][ 6 ] =  0.0;
            training[3][ 7 ] =  0.0;
            training[3][ 8 ] =  0.0;
            training[3][ 9 ] =  0.0;
            training[3][ 10 ] =  0.46973088;
            training[3][ 11 ] =  0.9336827;
            training[3][ 12 ] =  0.0;
            training[3][ 13 ] =  1.7215008;
            training[3][ 14 ] =  1.7828153;
            training[3][ 15 ] =  0.0;
            training[3][ 16 ] =  0.48441646;
            training[3][ 17 ] =  1.2484797;
            training[3][ 18 ] =  1.0901607;
            training[3][ 19 ] =  0.8392792;
            training[3][ 20 ] =  0.0;
            training[3][ 21 ] =  0.0;
            training[3][ 22 ] =  1.4414332;
            training[3][ 23 ] =  1.8589462;
            training[3][ 24 ] =  0.0;
            training[3][ 25 ] =  0.43212885;
            training[3][ 26 ] =  2.267332;
            training[3][ 27 ] =  1.1610863;
            training[3][ 28 ] =  0.0;
            training[3][ 29 ] =  1.2600656;
            training[3][ 30 ] =  0.0;
            training[3][ 31 ] =  0.11712992;
            training[3][ 32 ] =  0.4310727;
            training[3][ 33 ] =  0.0;
            training[3][ 34 ] =  0.0;
            training[3][ 35 ] =  0.0;
            training[3][ 36 ] =  0.0;
            training[3][ 37 ] =  1.6918187;
            training[3][ 38 ] =  0.0;
            training[3][ 39 ] =  0.0;
            training[3][ 40 ] =  0.0;
            training[3][ 41 ] =  0.0;
            training[3][ 42 ] =  1.4109123;
            training[3][ 43 ] =  1.3766583;
            training[3][ 44 ] =  0.0;
            training[3][ 45 ] =  1.8565314;
            training[3][ 46 ] =  2.085095;
            training[3][ 47 ] =  0.0;
            training[3][ 48 ] =  0.59696394;
            training[3][ 49 ] =  1.301408;
            training[3][ 50 ] =  1.2632854;
            training[3][ 51 ] =  0.36720967;
            training[3][ 52 ] =  0.0;
            training[3][ 53 ] =  0.0;
            training[3][ 54 ] =  0.69752216;
            training[3][ 55 ] =  1.4342992;
            training[3][ 56 ] =  0.0;
            training[3][ 57 ] =  0.09837275;
            training[3][ 58 ] =  2.0359855;
            training[3][ 59 ] =  0.6657598;
            training[3][ 60 ] =  0.0;
            training[3][ 61 ] =  1.0964285;
            training[3][ 62 ] =  0.0;
            training[3][ 63 ] =  0.6719787;
            training[3][ 64 ] =  0.7931198;
            training[3][ 65 ] =  0.0;
            training[3][ 66 ] =  0.0;
            training[3][ 67 ] =  1.2588441;
            training[3][ 68 ] =  0.0;
            training[3][ 69 ] =  2.5209298;
            training[3][ 70 ] =  0.0;
            training[3][ 71 ] =  0.0;
            training[3][ 72 ] =  0.0;
            training[3][ 73 ] =  0.0;
            training[3][ 74 ] =  4.8007784;
            training[3][ 75 ] =  2.691891;
            training[3][ 76 ] =  0.0;
            training[3][ 77 ] =  1.6136796;
            training[3][ 78 ] =  3.7590876;
            training[3][ 79 ] =  0.0;
            training[3][ 80 ] =  0.9044039;
            training[3][ 81 ] =  3.5514195;
            training[3][ 82 ] =  1.0521995;
            training[3][ 83 ] =  1.0467353;
            training[3][ 84 ] =  0.0;
            training[3][ 85 ] =  0.0;
            training[3][ 86 ] =  0.0;
            training[3][ 87 ] =  0.7729126;
            training[3][ 88 ] =  0.0;
            training[3][ 89 ] =  0.48792425;
            training[3][ 90 ] =  0.5207541;
            training[3][ 91 ] =  0.9169843;
            training[3][ 92 ] =  0.0;
            training[3][ 93 ] =  0.10120964;
            training[3][ 94 ] =  0.0;
            training[3][ 95 ] =  1.4953865;
            training[4][ 0 ] =  0.0;
            training[4][ 1 ] =  0.0;
            training[4][ 2 ] =  0.0;
            training[4][ 3 ] =  0.0;
            training[4][ 4 ] =  0.0;
            training[4][ 5 ] =  0.31987876;
            training[4][ 6 ] =  0.0;
            training[4][ 7 ] =  0.0;
            training[4][ 8 ] =  0.0;
            training[4][ 9 ] =  0.0;
            training[4][ 10 ] =  1.4030054;
            training[4][ 11 ] =  0.8988409;
            training[4][ 12 ] =  0.0;
            training[4][ 13 ] =  1.2168691;
            training[4][ 14 ] =  1.1880006;
            training[4][ 15 ] =  0.0;
            training[4][ 16 ] =  0.7480902;
            training[4][ 17 ] =  0.5135374;
            training[4][ 18 ] =  0.7677679;
            training[4][ 19 ] =  0.0;
            training[4][ 20 ] =  0.0;
            training[4][ 21 ] =  0.0;
            training[4][ 22 ] =  2.290632;
            training[4][ 23 ] =  1.8362372;
            training[4][ 24 ] =  0.0;
            training[4][ 25 ] =  0.53273356;
            training[4][ 26 ] =  1.5157351;
            training[4][ 27 ] =  0.5483825;
            training[4][ 28 ] =  0.0;
            training[4][ 29 ] =  0.52331066;
            training[4][ 30 ] =  0.0;
            training[4][ 31 ] =  0.0;
            training[4][ 32 ] =  0.5863151;
            training[4][ 33 ] =  0.0;
            training[4][ 34 ] =  0.0;
            training[4][ 35 ] =  0.0;
            training[4][ 36 ] =  0.0;
            training[4][ 37 ] =  0.3846237;
            training[4][ 38 ] =  0.0;
            training[4][ 39 ] =  0.0;
            training[4][ 40 ] =  0.0;
            training[4][ 41 ] =  0.0;
            training[4][ 42 ] =  0.0;
            training[4][ 43 ] =  0.33577713;
            training[4][ 44 ] =  0.0;
            training[4][ 45 ] =  1.9154804;
            training[4][ 46 ] =  0.65414965;
            training[4][ 47 ] =  0.0;
            training[4][ 48 ] =  0.74048513;
            training[4][ 49 ] =  0.9763073;
            training[4][ 50 ] =  1.1102061;
            training[4][ 51 ] =  0.4424119;
            training[4][ 52 ] =  0.0;
            training[4][ 53 ] =  0.0;
            training[4][ 54 ] =  1.9125142;
            training[4][ 55 ] =  1.5074385;
            training[4][ 56 ] =  0.0;
            training[4][ 57 ] =  0.4331271;
            training[4][ 58 ] =  2.489251;
            training[4][ 59 ] =  0.9294312;
            training[4][ 60 ] =  0.0;
            training[4][ 61 ] =  1.5925182;
            training[4][ 62 ] =  0.0;
            training[4][ 63 ] =  0.19975674;
            training[4][ 64 ] =  0.0;
            training[4][ 65 ] =  0.0;
            training[4][ 66 ] =  0.0;
            training[4][ 67 ] =  0.2663772;
            training[4][ 68 ] =  0.0;
            training[4][ 69 ] =  0.53758043;
            training[4][ 70 ] =  0.0;
            training[4][ 71 ] =  0.0;
            training[4][ 72 ] =  0.0;
            training[4][ 73 ] =  0.0;
            training[4][ 74 ] =  3.0188632;
            training[4][ 75 ] =  1.058633;
            training[4][ 76 ] =  0.0;
            training[4][ 77 ] =  0.86154914;
            training[4][ 78 ] =  1.2320846;
            training[4][ 79 ] =  0.0;
            training[4][ 80 ] =  0.58939046;
            training[4][ 81 ] =  1.4578509;
            training[4][ 82 ] =  0.3294212;
            training[4][ 83 ] =  0.84600735;
            training[4][ 84 ] =  0.0;
            training[4][ 85 ] =  0.0;
            training[4][ 86 ] =  2.4267697;
            training[4][ 87 ] =  1.6748093;
            training[4][ 88 ] =  0.0;
            training[4][ 89 ] =  0.51631004;
            training[4][ 90 ] =  0.6311717;
            training[4][ 91 ] =  2.344007;
            training[4][ 92 ] =  0.0;
            training[4][ 93 ] =  0.43605995;
            training[4][ 94 ] =  0.0;
            training[4][ 95 ] =  0.98570734;
            training[5][ 0 ] =  0.49890918;
            training[5][ 1 ] =  0.0;
            training[5][ 2 ] =  0.0;
            training[5][ 3 ] =  0.0;
            training[5][ 4 ] =  0.0;
            training[5][ 5 ] =  0.31228417;
            training[5][ 6 ] =  0.0;
            training[5][ 7 ] =  0.0;
            training[5][ 8 ] =  0.0;
            training[5][ 9 ] =  0.0;
            training[5][ 10 ] =  1.1014373;
            training[5][ 11 ] =  1.350907;
            training[5][ 12 ] =  0.0;
            training[5][ 13 ] =  1.4800854;
            training[5][ 14 ] =  1.4039513;
            training[5][ 15 ] =  0.0;
            training[5][ 16 ] =  0.46541804;
            training[5][ 17 ] =  0.035782814;
            training[5][ 18 ] =  0.86205673;
            training[5][ 19 ] =  0.0;
            training[5][ 20 ] =  0.0;
            training[5][ 21 ] =  0.0;
            training[5][ 22 ] =  1.8209856;
            training[5][ 23 ] =  1.2798256;
            training[5][ 24 ] =  0.0;
            training[5][ 25 ] =  0.6711182;
            training[5][ 26 ] =  1.896535;
            training[5][ 27 ] =  0.33325815;
            training[5][ 28 ] =  0.0;
            training[5][ 29 ] =  0.25403333;
            training[5][ 30 ] =  0.0;
            training[5][ 31 ] =  0.0;
            training[5][ 32 ] =  0.41128486;
            training[5][ 33 ] =  0.0;
            training[5][ 34 ] =  0.0;
            training[5][ 35 ] =  0.0;
            training[5][ 36 ] =  0.0;
            training[5][ 37 ] =  0.18647343;
            training[5][ 38 ] =  0.0;
            training[5][ 39 ] =  0.0;
            training[5][ 40 ] =  0.0;
            training[5][ 41 ] =  0.0;
            training[5][ 42 ] =  0.8501301;
            training[5][ 43 ] =  0.11502227;
            training[5][ 44 ] =  0.0;
            training[5][ 45 ] =  1.9035957;
            training[5][ 46 ] =  0.077816844;
            training[5][ 47 ] =  0.0;
            training[5][ 48 ] =  1.0214114;
            training[5][ 49 ] =  0.9882176;
            training[5][ 50 ] =  1.2605277;
            training[5][ 51 ] =  0.07790065;
            training[5][ 52 ] =  0.0;
            training[5][ 53 ] =  0.0;
            training[5][ 54 ] =  1.8058186;
            training[5][ 55 ] =  0.91557574;
            training[5][ 56 ] =  0.0;
            training[5][ 57 ] =  0.66245633;
            training[5][ 58 ] =  2.2802749;
            training[5][ 59 ] =  0.9047046;
            training[5][ 60 ] =  0.0;
            training[5][ 61 ] =  2.2603016;
            training[5][ 62 ] =  0.0;
            training[5][ 63 ] =  0.2851473;
            training[5][ 64 ] =  0.0;
            training[5][ 65 ] =  0.0;
            training[5][ 66 ] =  0.0;
            training[5][ 67 ] =  0.06630468;
            training[5][ 68 ] =  0.0;
            training[5][ 69 ] =  1.0012312;
            training[5][ 70 ] =  0.0;
            training[5][ 71 ] =  0.0;
            training[5][ 72 ] =  0.0;
            training[5][ 73 ] =  0.0;
            training[5][ 74 ] =  7.365668;
            training[5][ 75 ] =  2.3563654;
            training[5][ 76 ] =  0.0;
            training[5][ 77 ] =  0.0;
            training[5][ 78 ] =  2.6916647;
            training[5][ 79 ] =  0.0;
            training[5][ 80 ] =  0.48368067;
            training[5][ 81 ] =  1.1530778;
            training[5][ 82 ] =  0.45027286;
            training[5][ 83 ] =  0.0;
            training[5][ 84 ] =  0.0;
            training[5][ 85 ] =  0.0;
            training[5][ 86 ] =  1.4791884;
            training[5][ 87 ] =  0.8298547;
            training[5][ 88 ] =  0.0;
            training[5][ 89 ] =  1.3303931;
            training[5][ 90 ] =  0.0;
            training[5][ 91 ] =  0.9724016;
            training[5][ 92 ] =  0.0;
            training[5][ 93 ] =  0.0;
            training[5][ 94 ] =  0.0;
            training[5][ 95 ] =  0.8516512;
            training[6][ 0 ] =  0.53776795;
            training[6][ 1 ] =  0.0;
            training[6][ 2 ] =  0.0;
            training[6][ 3 ] =  0.41082096;
            training[6][ 4 ] =  0.0;
            training[6][ 5 ] =  0.8934943;
            training[6][ 6 ] =  0.0;
            training[6][ 7 ] =  0.0;
            training[6][ 8 ] =  0.0;
            training[6][ 9 ] =  0.0;
            training[6][ 10 ] =  0.6803409;
            training[6][ 11 ] =  0.5421015;
            training[6][ 12 ] =  0.0;
            training[6][ 13 ] =  1.6185753;
            training[6][ 14 ] =  1.1731393;
            training[6][ 15 ] =  0.0;
            training[6][ 16 ] =  0.37057132;
            training[6][ 17 ] =  1.5774558;
            training[6][ 18 ] =  0.80836594;
            training[6][ 19 ] =  1.463579;
            training[6][ 20 ] =  0.0;
            training[6][ 21 ] =  0.0;
            training[6][ 22 ] =  1.7953687;
            training[6][ 23 ] =  1.4274248;
            training[6][ 24 ] =  0.0;
            training[6][ 25 ] =  0.36935788;
            training[6][ 26 ] =  2.3923678;
            training[6][ 27 ] =  2.3224447;
            training[6][ 28 ] =  0.0;
            training[6][ 29 ] =  2.108954;
            training[6][ 30 ] =  0.0;
            training[6][ 31 ] =  0.8743139;
            training[6][ 32 ] =  0.6796824;
            training[6][ 33 ] =  0.0;
            training[6][ 34 ] =  0.0;
            training[6][ 35 ] =  0.1884768;
            training[6][ 36 ] =  0.0;
            training[6][ 37 ] =  0.67504805;
            training[6][ 38 ] =  0.0;
            training[6][ 39 ] =  0.0;
            training[6][ 40 ] =  0.0;
            training[6][ 41 ] =  0.0;
            training[6][ 42 ] =  0.9441061;
            training[6][ 43 ] =  0.79701245;
            training[6][ 44 ] =  0.0;
            training[6][ 45 ] =  1.8775926;
            training[6][ 46 ] =  1.9840173;
            training[6][ 47 ] =  0.0;
            training[6][ 48 ] =  0.37551403;
            training[6][ 49 ] =  1.4183048;
            training[6][ 50 ] =  0.9275647;
            training[6][ 51 ] =  1.6430821;
            training[6][ 52 ] =  0.0;
            training[6][ 53 ] =  0.0;
            training[6][ 54 ] =  1.2082525;
            training[6][ 55 ] =  1.7539583;
            training[6][ 56 ] =  0.0;
            training[6][ 57 ] =  0.5992441;
            training[6][ 58 ] =  2.3218763;
            training[6][ 59 ] =  1.719348;
            training[6][ 60 ] =  0.0;
            training[6][ 61 ] =  1.589152;
            training[6][ 62 ] =  0.0;
            training[6][ 63 ] =  0.37402564;
            training[6][ 64 ] =  0.0;
            training[6][ 65 ] =  0.0;
            training[6][ 66 ] =  0.0;
            training[6][ 67 ] =  1.2096882;
            training[6][ 68 ] =  0.0;
            training[6][ 69 ] =  1.3673925;
            training[6][ 70 ] =  0.0;
            training[6][ 71 ] =  0.0;
            training[6][ 72 ] =  0.0;
            training[6][ 73 ] =  0.0;
            training[6][ 74 ] =  3.7020147;
            training[6][ 75 ] =  1.0015597;
            training[6][ 76 ] =  0.0;
            training[6][ 77 ] =  1.1454381;
            training[6][ 78 ] =  0.35105252;
            training[6][ 79 ] =  0.0;
            training[6][ 80 ] =  0.7422212;
            training[6][ 81 ] =  2.3215148;
            training[6][ 82 ] =  1.0266922;
            training[6][ 83 ] =  0.6027565;
            training[6][ 84 ] =  0.0;
            training[6][ 85 ] =  0.0;
            training[6][ 86 ] =  1.101306;
            training[6][ 87 ] =  0.014128208;
            training[6][ 88 ] =  0.0;
            training[6][ 89 ] =  0.92416924;
            training[6][ 90 ] =  0.90513027;
            training[6][ 91 ] =  2.4931133;
            training[6][ 92 ] =  0.0;
            training[6][ 93 ] =  2.986218;
            training[6][ 94 ] =  0.0;
            training[6][ 95 ] =  2.013473;
            training[7][ 0 ] =  0.0;
            training[7][ 1 ] =  0.0;
            training[7][ 2 ] =  0.0;
            training[7][ 3 ] =  0.0;
            training[7][ 4 ] =  0.0;
            training[7][ 5 ] =  0.663987;
            training[7][ 6 ] =  0.0;
            training[7][ 7 ] =  0.0;
            training[7][ 8 ] =  0.0;
            training[7][ 9 ] =  0.0;
            training[7][ 10 ] =  0.31456068;
            training[7][ 11 ] =  0.4408109;
            training[7][ 12 ] =  0.0;
            training[7][ 13 ] =  1.5726619;
            training[7][ 14 ] =  0.57735884;
            training[7][ 15 ] =  0.0;
            training[7][ 16 ] =  0.78228587;
            training[7][ 17 ] =  0.993554;
            training[7][ 18 ] =  0.7247913;
            training[7][ 19 ] =  0.4938097;
            training[7][ 20 ] =  0.0;
            training[7][ 21 ] =  0.0;
            training[7][ 22 ] =  2.6981769;
            training[7][ 23 ] =  1.7729414;
            training[7][ 24 ] =  0.0;
            training[7][ 25 ] =  0.32217056;
            training[7][ 26 ] =  2.3025815;
            training[7][ 27 ] =  1.833713;
            training[7][ 28 ] =  0.0;
            training[7][ 29 ] =  2.021355;
            training[7][ 30 ] =  0.0;
            training[7][ 31 ] =  0.7374674;
            training[7][ 32 ] =  1.0207841;
            training[7][ 33 ] =  0.0;
            training[7][ 34 ] =  0.0;
            training[7][ 35 ] =  0.6245675;
            training[7][ 36 ] =  0.0;
            training[7][ 37 ] =  1.2709886;
            training[7][ 38 ] =  0.0;
            training[7][ 39 ] =  0.0;
            training[7][ 40 ] =  0.0;
            training[7][ 41 ] =  0.0;
            training[7][ 42 ] =  1.7994256;
            training[7][ 43 ] =  1.3678167;
            training[7][ 44 ] =  0.0;
            training[7][ 45 ] =  1.5986644;
            training[7][ 46 ] =  2.727394;
            training[7][ 47 ] =  0.0;
            training[7][ 48 ] =  0.06065931;
            training[7][ 49 ] =  1.6824446;
            training[7][ 50 ] =  0.9322659;
            training[7][ 51 ] =  1.9008056;
            training[7][ 52 ] =  0.0;
            training[7][ 53 ] =  0.0;
            training[7][ 54 ] =  0.6438848;
            training[7][ 55 ] =  1.6550043;
            training[7][ 56 ] =  0.0;
            training[7][ 57 ] =  0.37504438;
            training[7][ 58 ] =  2.1503444;
            training[7][ 59 ] =  1.862539;
            training[7][ 60 ] =  0.0;
            training[7][ 61 ] =  1.5705701;
            training[7][ 62 ] =  0.0;
            training[7][ 63 ] =  0.2659235;
            training[7][ 64 ] =  2.039678;
            training[7][ 65 ] =  0.11331944;
            training[7][ 66 ] =  1.3496735;
            training[7][ 67 ] =  1.6486734;
            training[7][ 68 ] =  1.8213145;
            training[7][ 69 ] =  1.0251255;
            training[7][ 70 ] =  0.0;
            training[7][ 71 ] =  0.0;
            training[7][ 72 ] =  0.0;
            training[7][ 73 ] =  0.009049007;
            training[7][ 74 ] =  0.19643244;
            training[7][ 75 ] =  0.7227336;
            training[7][ 76 ] =  0.0;
            training[7][ 77 ] =  2.321944;
            training[7][ 78 ] =  2.5732322;
            training[7][ 79 ] =  0.0;
            training[7][ 80 ] =  0.0;
            training[7][ 81 ] =  2.3947258;
            training[7][ 82 ] =  1.0197991;
            training[7][ 83 ] =  3.340733;
            training[7][ 84 ] =  0.0;
            training[7][ 85 ] =  2.402991;
            training[7][ 86 ] =  0.18773091;
            training[7][ 87 ] =  1.6812022;
            training[7][ 88 ] =  0.0;
            training[7][ 89 ] =  0.11165057;
            training[7][ 90 ] =  3.1588066;
            training[7][ 91 ] =  2.706769;
            training[7][ 92 ] =  0.0;
            training[7][ 93 ] =  2.452242;
            training[7][ 94 ] =  0.0;
            training[7][ 95 ] =  0.25254655;
            training[8][ 0 ] =  0.0;
            training[8][ 1 ] =  0.0;
            training[8][ 2 ] =  0.100310564;
            training[8][ 3 ] =  0.750831;
            training[8][ 4 ] =  0.23913312;
            training[8][ 5 ] =  0.096832514;
            training[8][ 6 ] =  0.0;
            training[8][ 7 ] =  0.0;
            training[8][ 8 ] =  0.0;
            training[8][ 9 ] =  0.0;
            training[8][ 10 ] =  0.0;
            training[8][ 11 ] =  0.0;
            training[8][ 12 ] =  0.0;
            training[8][ 13 ] =  1.2515241;
            training[8][ 14 ] =  0.0;
            training[8][ 15 ] =  0.0;
            training[8][ 16 ] =  0.65937126;
            training[8][ 17 ] =  1.2507777;
            training[8][ 18 ] =  0.62060773;
            training[8][ 19 ] =  0.81029034;
            training[8][ 20 ] =  0.0;
            training[8][ 21 ] =  0.0;
            training[8][ 22 ] =  4.1486588;
            training[8][ 23 ] =  1.4034791;
            training[8][ 24 ] =  0.020884927;
            training[8][ 25 ] =  0.6409513;
            training[8][ 26 ] =  2.496435;
            training[8][ 27 ] =  3.3193808;
            training[8][ 28 ] =  0.0;
            training[8][ 29 ] =  3.3781538;
            training[8][ 30 ] =  0.0;
            training[8][ 31 ] =  1.4928741;
            training[8][ 32 ] =  0.054682434;
            training[8][ 33 ] =  0.0;
            training[8][ 34 ] =  0.0;
            training[8][ 35 ] =  0.0;
            training[8][ 36 ] =  0.0;
            training[8][ 37 ] =  0.019649029;
            training[8][ 38 ] =  0.0;
            training[8][ 39 ] =  0.0;
            training[8][ 40 ] =  0.0;
            training[8][ 41 ] =  0.0;
            training[8][ 42 ] =  0.0;
            training[8][ 43 ] =  0.0;
            training[8][ 44 ] =  0.0;
            training[8][ 45 ] =  1.6671014;
            training[8][ 46 ] =  0.0;
            training[8][ 47 ] =  0.0;
            training[8][ 48 ] =  1.14074;
            training[8][ 49 ] =  1.4752028;
            training[8][ 50 ] =  0.9468895;
            training[8][ 51 ] =  0.20114017;
            training[8][ 52 ] =  0.0;
            training[8][ 53 ] =  0.0;
            training[8][ 54 ] =  2.963605;
            training[8][ 55 ] =  1.4593968;
            training[8][ 56 ] =  0.0;
            training[8][ 57 ] =  0.4421139;
            training[8][ 58 ] =  2.487212;
            training[8][ 59 ] =  1.742836;
            training[8][ 60 ] =  0.0;
            training[8][ 61 ] =  2.341564;
            training[8][ 62 ] =  0.0;
            training[8][ 63 ] =  0.570104;
            training[8][ 64 ] =  0.0;
            training[8][ 65 ] =  0.0;
            training[8][ 66 ] =  0.0;
            training[8][ 67 ] =  0.1857264;
            training[8][ 68 ] =  0.0;
            training[8][ 69 ] =  1.3388727;
            training[8][ 70 ] =  0.0;
            training[8][ 71 ] =  0.0;
            training[8][ 72 ] =  0.0;
            training[8][ 73 ] =  0.0;
            training[8][ 74 ] =  6.5764165;
            training[8][ 75 ] =  2.6635358;
            training[8][ 76 ] =  0.0;
            training[8][ 77 ] =  0.44911814;
            training[8][ 78 ] =  3.6401916;
            training[8][ 79 ] =  0.0;
            training[8][ 80 ] =  0.2980018;
            training[8][ 81 ] =  1.7823889;
            training[8][ 82 ] =  0.3543062;
            training[8][ 83 ] =  0.91627836;
            training[8][ 84 ] =  0.0;
            training[8][ 85 ] =  0.0;
            training[8][ 86 ] =  0.3389542;
            training[8][ 87 ] =  1.2622486;
            training[8][ 88 ] =  0.0;
            training[8][ 89 ] =  0.9869686;
            training[8][ 90 ] =  0.0;
            training[8][ 91 ] =  1.1029665;
            training[8][ 92 ] =  0.0;
            training[8][ 93 ] =  0.0;
            training[8][ 94 ] =  0.0;
            training[8][ 95 ] =  0.7513708;
            training[9][ 0 ] =  0.926754;
            training[9][ 1 ] =  0.0;
            training[9][ 2 ] =  0.0;
            training[9][ 3 ] =  0.041611195;
            training[9][ 4 ] =  0.0;
            training[9][ 5 ] =  0.7793167;
            training[9][ 6 ] =  0.0;
            training[9][ 7 ] =  0.0;
            training[9][ 8 ] =  0.0;
            training[9][ 9 ] =  0.0;
            training[9][ 10 ] =  0.85084724;
            training[9][ 11 ] =  0.8864503;
            training[9][ 12 ] =  0.0;
            training[9][ 13 ] =  1.796611;
            training[9][ 14 ] =  1.6932843;
            training[9][ 15 ] =  0.0;
            training[9][ 16 ] =  0.34776986;
            training[9][ 17 ] =  1.4059839;
            training[9][ 18 ] =  0.90143234;
            training[9][ 19 ] =  1.504709;
            training[9][ 20 ] =  0.0;
            training[9][ 21 ] =  0.0;
            training[9][ 22 ] =  1.3594313;
            training[9][ 23 ] =  1.43325;
            training[9][ 24 ] =  0.0;
            training[9][ 25 ] =  0.35322243;
            training[9][ 26 ] =  2.388419;
            training[9][ 27 ] =  1.6817913;
            training[9][ 28 ] =  0.0;
            training[9][ 29 ] =  1.6185355;
            training[9][ 30 ] =  0.0;
            training[9][ 31 ] =  0.3789873;
            training[9][ 32 ] =  0.8471611;
            training[9][ 33 ] =  0.0;
            training[9][ 34 ] =  0.0;
            training[9][ 35 ] =  1.3609071;
            training[9][ 36 ] =  0.5386939;
            training[9][ 37 ] =  1.4138615;
            training[9][ 38 ] =  0.0;
            training[9][ 39 ] =  0.0;
            training[9][ 40 ] =  0.0;
            training[9][ 41 ] =  0.0;
            training[9][ 42 ] =  1.3710061;
            training[9][ 43 ] =  1.0084807;
            training[9][ 44 ] =  0.0;
            training[9][ 45 ] =  1.9192452;
            training[9][ 46 ] =  2.1307986;
            training[9][ 47 ] =  0.0;
            training[9][ 48 ] =  0.4565128;
            training[9][ 49 ] =  2.2410448;
            training[9][ 50 ] =  0.78778315;
            training[9][ 51 ] =  2.1503181;
            training[9][ 52 ] =  0.0;
            training[9][ 53 ] =  0.0;
            training[9][ 54 ] =  0.83238447;
            training[9][ 55 ] =  1.7040293;
            training[9][ 56 ] =  0.0;
            training[9][ 57 ] =  0.007147327;
            training[9][ 58 ] =  2.1612642;
            training[9][ 59 ] =  2.5349388;
            training[9][ 60 ] =  0.0;
            training[9][ 61 ] =  1.8899455;
            training[9][ 62 ] =  0.0;
            training[9][ 63 ] =  0.9446115;
            training[9][ 64 ] =  0.0;
            training[9][ 65 ] =  0.0;
            training[9][ 66 ] =  0.0;
            training[9][ 67 ] =  0.81887317;
            training[9][ 68 ] =  0.0;
            training[9][ 69 ] =  0.0;
            training[9][ 70 ] =  0.0;
            training[9][ 71 ] =  0.0;
            training[9][ 72 ] =  0.0;
            training[9][ 73 ] =  0.0;
            training[9][ 74 ] =  1.2885363;
            training[9][ 75 ] =  0.0;
            training[9][ 76 ] =  0.0;
            training[9][ 77 ] =  0.5750258;
            training[9][ 78 ] =  0.0;
            training[9][ 79 ] =  0.0;
            training[9][ 80 ] =  0.0;
            training[9][ 81 ] =  0.46559763;
            training[9][ 82 ] =  0.3886965;
            training[9][ 83 ] =  1.3439064;
            training[9][ 84 ] =  0.0;
            training[9][ 85 ] =  0.0;
            training[9][ 86 ] =  4.244321;
            training[9][ 87 ] =  1.5816512;
            training[9][ 88 ] =  0.0;
            training[9][ 89 ] =  0.98004377;
            training[9][ 90 ] =  1.6120588;
            training[9][ 91 ] =  3.5927734;
            training[9][ 92 ] =  0.0;
            training[9][ 93 ] =  3.6165903;
            training[9][ 94 ] =  0.0;
            training[9][ 95 ] =  0.7125958;

            
            //now we will train with each of the training sets:
            for (int tr = 0; tr < num_of_train; tr++){
                train(inputs, training[tr], true, 0.1);
            }
            
            double[] outputs = new double[height];
            int trac1 = 0;
            int trac2 = 0;
            
            for (int num = 0; num < 100; num++){
                Random rand = new Random();

		// Obtain a number between [0 - height-1].
		int index = rand.nextInt(height-1);
                
                //now change the input node at index index:
                inputs[index] = inputs[index] + 1;
                
                //now run the network:
                outputs = run_net(inputs);
                
                for (int i = 0; i < height; i++){
                    if (i < height/3){
                        trac2 = 0;
                        System.out.println("inputs[" + trac1 + "][" + trac2 + "][" + i + "] = " + outputs[i]);
                    }
                    else if (i >= height/3 && i < 2*height/3){
                        trac2 = 1;
                        System.out.println("inputs[" + trac1 + "][" + trac2 + "][" + (i-height/3) + "] = " + outputs[i]);
                    }
                    else{
                        trac2 = 2;
                        System.out.println("inputs[" + trac1 + "][" + trac2 + "][" + (i-(2*height/3)) + "] = " + outputs[i]);
                    }
                
                } 
                trac1++;
                    
                
            }
        
        }
      
        public static double[] setup(){
            double[] out = new double[height*height*layers+3];
            for (int i = 0; i < height*height*layers+3; i ++){
                out[i] = random_number();
                //System.out.println(out[i]);
            }
            return out;
        }
        
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
           
        }
        
        public static double[] run_net (double[] inputs){
            
            double outputs[] = new double[height];
            double layer[][] = new double[height][layers];
            
            int trac1 = 0;
          
            
            //this method runs the network
            for (int i = 0; i < layers; i++){
                //for each layer, calc each neuron:
                for (int j = 0; j < height; j++){
                    //if it is the first time...
                    if (i == 0){
                        double output = 0;
            
                        for (int n = 0; n < height; n++){
                            output = output + weights[trac1]*inputs[n];
				
				trac1++;
                        }
                        
                        output = Math.pow(e, output) / (Math.pow(e, output) + 1); //sigmoid func

                        
                        layer[j][i] = output;
                        if (Double.isNaN(layer[j][i])){
                            layer[j][i] = 1E-3;
                        }
                    }
                    
                    //else if it is the last time...
                    else if (i == layers-1){
                        double output = 0;
            
                        for (int n = 0; n < height; n++){
                            output = output + weights[trac1]*layer[n][i-1];
				
                            trac1++;
                        }

                        //output = Math.pow(e, output) / (Math.pow(e, output) + 1); //sigmoid func

                        
                        layer[j][i] = output;
                        if (Double.isNaN(layer[j][i])){
                            layer[j][i] = 1E-3;
                        }
                        outputs[j] = layer[j][i];
                        
                        
                    }
                    
                    //else...
                    else {
                        double output = 0;
            
                        for (int n = 0; n < height; n++){
                            output = output + weights[trac1]*layer[n][i-1];
				trac1++;
				
                        }

                        output = Math.pow(e, output) / (Math.pow(e, output) + 1); //sigmoid func

                        
                        layer[j][i] = output;
                        if (Double.isNaN(layer[j][i])){
                            layer[j][i] = 1E-3;
                        }
                    }
                    
                    //System.out.println(layer[j][i]);
                    
                }
                
            }
            
            return outputs;
        }
    
        //fuction to genetrate random decimals
        public static double random_number(){
		Random rand = new Random();

		// Obtain a number between [0 - 199].
		double n = rand.nextInt(199);
		
		n = n/100;
		n = n - 1;
		return n;
        }
    
}package autoencoder_inputs;

import java.util.Random;

public class Autoencoder_inputs {
    
        public static int height = 96;
        public static int layers = 50;
        public static double e =  2.7182818284590452;
        public static double[] weights;

        public static void main(String[] args) {
            
            weights = new double[height*height*layers+3];
            weights = setup();
            
            double[] inputs = new double[height];
            
            //start by setting each value to 1
            for (int n = 0; n < height; n++){
                inputs[n] = 1;
            }
            
            int num_of_train = 10;
            System.out.println("Starting...");
     
            double[][] training = new double[num_of_train][height];
            //set the values of training right here:
            //...
            training[0][ 0 ] =  0.19599748;
            training[0][ 1 ] =  0.0;
            training[0][ 2 ] =  0.0;
            training[0][ 3 ] =  0.78626394;
            training[0][ 4 ] =  0.358055;
            training[0][ 5 ] =  0.61432743;
            training[0][ 6 ] =  0.0;
            training[0][ 7 ] =  0.0;
            training[0][ 8 ] =  0.0;
            training[0][ 9 ] =  0.0;
            training[0][ 10 ] =  0.24464753;
            training[0][ 11 ] =  0.0;
            training[0][ 12 ] =  0.0;
            training[0][ 13 ] =  1.6429505;
            training[0][ 14 ] =  0.11605394;
            training[0][ 15 ] =  0.0;
            training[0][ 16 ] =  0.92686397;
            training[0][ 17 ] =  1.9690541;
            training[0][ 18 ] =  0.94740653;
            training[0][ 19 ] =  1.1184592;
            training[0][ 20 ] =  0.0;
            training[0][ 21 ] =  0.0;
            training[0][ 22 ] =  2.4323614;
            training[0][ 23 ] =  1.1971267;
            training[0][ 24 ] =  0.0;
            training[0][ 25 ] =  0.53294826;
            training[0][ 26 ] =  2.514844;
            training[0][ 27 ] =  2.3552973;
            training[0][ 28 ] =  0.0;
            training[0][ 29 ] =  2.949084;
            training[0][ 30 ] =  0.0;
            training[0][ 31 ] =  1.0382521;
            training[0][ 32 ] =  0.55146945;
            training[0][ 33 ] =  0.0;
            training[0][ 34 ] =  0.0;
            training[0][ 35 ] =  0.35524654;
            training[0][ 36 ] =  0.0;
            training[0][ 37 ] =  0.5421135;
            training[0][ 38 ] =  0.0;
            training[0][ 39 ] =  0.0;
            training[0][ 40 ] =  0.0;
            training[0][ 41 ] =  0.0;
            training[0][ 42 ] =  0.5008888;
            training[0][ 43 ] =  0.6389437;
            training[0][ 44 ] =  0.0;
            training[0][ 45 ] =  1.674246;
            training[0][ 46 ] =  1.336958;
            training[0][ 47 ] =  0.0;
            training[0][ 48 ] =  0.42493117;
            training[0][ 49 ] =  1.6202114;
            training[0][ 50 ] =  0.75180435;
            training[0][ 51 ] =  1.5426235;
            training[0][ 52 ] =  0.0;
            training[0][ 53 ] =  0.0;
            training[0][ 54 ] =  1.9590834;
            training[0][ 55 ] =  1.8596251;
            training[0][ 56 ] =  0.0;
            training[0][ 57 ] =  0.22997347;
            training[0][ 58 ] =  2.3987355;
            training[0][ 59 ] =  2.1505141;
            training[0][ 60 ] =  0.0;
            training[0][ 61 ] =  1.5571076;
            training[0][ 62 ] =  0.0;
            training[0][ 63 ] =  0.3743024;
            training[0][ 64 ] =  0.0;
            training[0][ 65 ] =  0.0;
            training[0][ 66 ] =  0.0;
            training[0][ 67 ] =  0.0;
            training[0][ 68 ] =  0.0;
            training[0][ 69 ] =  0.0;
            training[0][ 70 ] =  0.0;
            training[0][ 71 ] =  0.0;
            training[0][ 72 ] =  0.0;
            training[0][ 73 ] =  0.0;
            training[0][ 74 ] =  3.2374585;
            training[0][ 75 ] =  0.33298275;
            training[0][ 76 ] =  0.0;
            training[0][ 77 ] =  0.09630406;
            training[0][ 78 ] =  0.0;
            training[0][ 79 ] =  0.0;
            training[0][ 80 ] =  0.23333183;
            training[0][ 81 ] =  0.0;
            training[0][ 82 ] =  0.7003182;
            training[0][ 83 ] =  0.0;
            training[0][ 84 ] =  0.0;
            training[0][ 85 ] =  0.0;
            training[0][ 86 ] =  3.6872742;
            training[0][ 87 ] =  0.880013;
            training[0][ 88 ] =  0.0;
            training[0][ 89 ] =  1.4517391;
            training[0][ 90 ] =  0.5658026;
            training[0][ 91 ] =  1.8375239;
            training[0][ 92 ] =  0.0;
            training[0][ 93 ] =  2.5850616;
            training[0][ 94 ] =  0.0;
            training[0][ 95 ] =  0.33033442;
            training[1][ 0 ] =  0.0;
            training[1][ 1 ] =  0.0;
            training[1][ 2 ] =  0.0;
            training[1][ 3 ] =  0.76830626;
            training[1][ 4 ] =  0.029274225;
            training[1][ 5 ] =  0.15952021;
            training[1][ 6 ] =  0.0;
            training[1][ 7 ] =  0.0;
            training[1][ 8 ] =  0.0;
            training[1][ 9 ] =  0.0;
            training[1][ 10 ] =  0.07445004;
            training[1][ 11 ] =  0.0;
            training[1][ 12 ] =  0.0;
            training[1][ 13 ] =  1.4011813;
            training[1][ 14 ] =  0.0;
            training[1][ 15 ] =  0.0;
            training[1][ 16 ] =  0.6740373;
            training[1][ 17 ] =  1.4924763;
            training[1][ 18 ] =  0.52908593;
            training[1][ 19 ] =  1.1761117;
            training[1][ 20 ] =  0.0;
            training[1][ 21 ] =  0.0;
            training[1][ 22 ] =  3.3300085;
            training[1][ 23 ] =  1.8026208;
            training[1][ 24 ] =  0.0;
            training[1][ 25 ] =  0.44974548;
            training[1][ 26 ] =  2.2233782;
            training[1][ 27 ] =  3.106435;
            training[1][ 28 ] =  0.0;
            training[1][ 29 ] =  2.4948325;
            training[1][ 30 ] =  0.0;
            training[1][ 31 ] =  1.0724303;
            training[1][ 32 ] =  0.36915702;
            training[1][ 33 ] =  0.0;
            training[1][ 34 ] =  0.0;
            training[1][ 35 ] =  0.40678024;
            training[1][ 36 ] =  0.0;
            training[1][ 37 ] =  0.9172284;
            training[1][ 38 ] =  0.0;
            training[1][ 39 ] =  0.0;
            training[1][ 40 ] =  0.0;
            training[1][ 41 ] =  0.0;
            training[1][ 42 ] =  1.7080134;
            training[1][ 43 ] =  0.7678571;
            training[1][ 44 ] =  0.0;
            training[1][ 45 ] =  1.4638903;
            training[1][ 46 ] =  1.3058349;
            training[1][ 47 ] =  0.0;
            training[1][ 48 ] =  0.44023424;
            training[1][ 49 ] =  1.3862967;
            training[1][ 50 ] =  0.9601307;
            training[1][ 51 ] =  1.1536608;
            training[1][ 52 ] =  0.0;
            training[1][ 53 ] =  0.0;
            training[1][ 54 ] =  1.4556047;
            training[1][ 55 ] =  1.2553295;
            training[1][ 56 ] =  0.0;
            training[1][ 57 ] =  0.51081175;
            training[1][ 58 ] =  1.9658213;
            training[1][ 59 ] =  1.9413738;
            training[1][ 60 ] =  0.0;
            training[1][ 61 ] =  2.1031778;
            training[1][ 62 ] =  0.0;
            training[1][ 63 ] =  0.8907339;
            training[1][ 64 ] =  1.3903952;
            training[1][ 65 ] =  0.0;
            training[1][ 66 ] =  0.2502458;
            training[1][ 67 ] =  1.695853;
            training[1][ 68 ] =  0.91240513;
            training[1][ 69 ] =  1.5741606;
            training[1][ 70 ] =  0.0;
            training[1][ 71 ] =  0.0;
            training[1][ 72 ] =  0.0;
            training[1][ 73 ] =  0.0;
            training[1][ 74 ] =  1.419775;
            training[1][ 75 ] =  1.2445148;
            training[1][ 76 ] =  0.0;
            training[1][ 77 ] =  2.0627768;
            training[1][ 78 ] =  2.7739592;
            training[1][ 79 ] =  0.0;
            training[1][ 80 ] =  0.074238926;
            training[1][ 81 ] =  2.574122;
            training[1][ 82 ] =  0.82936126;
            training[1][ 83 ] =  2.7429743;
            training[1][ 84 ] =  0.0;
            training[1][ 85 ] =  0.5846424;
            training[1][ 86 ] =  0.17156434;
            training[1][ 87 ] =  1.6465724;
            training[1][ 88 ] =  0.0;
            training[1][ 89 ] =  0.06819458;
            training[1][ 90 ] =  2.3644469;
            training[1][ 91 ] =  2.7305937;
            training[1][ 92 ] =  0.0;
            training[1][ 93 ] =  1.8720617;
            training[1][ 94 ] =  0.0;
            training[1][ 95 ] =  0.8592468;
            training[2][ 0 ] =  0.0;
            training[2][ 1 ] =  0.0;
            training[2][ 2 ] =  0.0;
            training[2][ 3 ] =  0.7871735;
            training[2][ 4 ] =  0.0;
            training[2][ 5 ] =  0.20313895;
            training[2][ 6 ] =  0.0;
            training[2][ 7 ] =  0.0;
            training[2][ 8 ] =  0.0;
            training[2][ 9 ] =  0.0;
            training[2][ 10 ] =  0.6256635;
            training[2][ 11 ] =  0.17643985;
            training[2][ 12 ] =  0.0;
            training[2][ 13 ] =  1.2431767;
            training[2][ 14 ] =  0.010138869;
            training[2][ 15 ] =  0.0;
            training[2][ 16 ] =  0.6335717;
            training[2][ 17 ] =  1.5317345;
            training[2][ 18 ] =  0.4354951;
            training[2][ 19 ] =  1.1079574;
            training[2][ 20 ] =  0.0;
            training[2][ 21 ] =  0.0;
            training[2][ 22 ] =  3.2773585;
            training[2][ 23 ] =  1.7432277;
            training[2][ 24 ] =  0.0;
            training[2][ 25 ] =  0.46704668;
            training[2][ 26 ] =  1.9168451;
            training[2][ 27 ] =  3.017709;
            training[2][ 28 ] =  0.0;
            training[2][ 29 ] =  2.2593408;
            training[2][ 30 ] =  0.0;
            training[2][ 31 ] =  1.0123687;
            training[2][ 32 ] =  0.19617438;
            training[2][ 33 ] =  0.0;
            training[2][ 34 ] =  0.0;
            training[2][ 35 ] =  0.0054318905;
            training[2][ 36 ] =  0.0;
            training[2][ 37 ] =  0.55425733;
            training[2][ 38 ] =  0.0;
            training[2][ 39 ] =  0.0;
            training[2][ 40 ] =  0.0;
            training[2][ 41 ] =  0.0;
            training[2][ 42 ] =  1.0425916;
            training[2][ 43 ] =  0.6839975;
            training[2][ 44 ] =  0.0;
            training[2][ 45 ] =  1.7350309;
            training[2][ 46 ] =  1.0329398;
            training[2][ 47 ] =  0.0;
            training[2][ 48 ] =  0.73834;
            training[2][ 49 ] =  1.4782132;
            training[2][ 50 ] =  0.9984645;
            training[2][ 51 ] =  0.8277502;
            training[2][ 52 ] =  0.0;
            training[2][ 53 ] =  0.0;
            training[2][ 54 ] =  1.8738863;
            training[2][ 55 ] =  1.6408322;
            training[2][ 56 ] =  0.0;
            training[2][ 57 ] =  0.5092326;
            training[2][ 58 ] =  1.9585748;
            training[2][ 59 ] =  1.6621859;
            training[2][ 60 ] =  0.0;
            training[2][ 61 ] =  1.7630236;
            training[2][ 62 ] =  0.0;
            training[2][ 63 ] =  0.6403208;
            training[2][ 64 ] =  1.2646418;
            training[2][ 65 ] =  0.015644008;
            training[2][ 66 ] =  1.0831121;
            training[2][ 67 ] =  2.1165686;
            training[2][ 68 ] =  1.4787362;
            training[2][ 69 ] =  1.0739417;
            training[2][ 70 ] =  0.0;
            training[2][ 71 ] =  0.0;
            training[2][ 72 ] =  0.0;
            training[2][ 73 ] =  0.040385935;
            training[2][ 74 ] =  0.9208743;
            training[2][ 75 ] =  0.6920581;
            training[2][ 76 ] =  0.0;
            training[2][ 77 ] =  1.9123447;
            training[2][ 78 ] =  2.1887777;
            training[2][ 79 ] =  0.0;
            training[2][ 80 ] =  0.08274713;
            training[2][ 81 ] =  2.6947086;
            training[2][ 82 ] =  0.86421454;
            training[2][ 83 ] =  3.1440425;
            training[2][ 84 ] =  0.0;
            training[2][ 85 ] =  1.9558805;
            training[2][ 86 ] =  0.80528116;
            training[2][ 87 ] =  1.59043;
            training[2][ 88 ] =  0.0;
            training[2][ 89 ] =  0.12752691;
            training[2][ 90 ] =  2.6590295;
            training[2][ 91 ] =  3.3651478;
            training[2][ 92 ] =  0.0;
            training[2][ 93 ] =  2.3002424;
            training[2][ 94 ] =  0.0;
            training[2][ 95 ] =  0.91259;
            training[3][ 0 ] =  0.67377335;
            training[3][ 1 ] =  0.0;
            training[3][ 2 ] =  0.0;
            training[3][ 3 ] =  0.0;
            training[3][ 4 ] =  0.0;
            training[3][ 5 ] =  0.8852939;
            training[3][ 6 ] =  0.0;
            training[3][ 7 ] =  0.0;
            training[3][ 8 ] =  0.0;
            training[3][ 9 ] =  0.0;
            training[3][ 10 ] =  0.46973088;
            training[3][ 11 ] =  0.9336827;
            training[3][ 12 ] =  0.0;
            training[3][ 13 ] =  1.7215008;
            training[3][ 14 ] =  1.7828153;
            training[3][ 15 ] =  0.0;
            training[3][ 16 ] =  0.48441646;
            training[3][ 17 ] =  1.2484797;
            training[3][ 18 ] =  1.0901607;
            training[3][ 19 ] =  0.8392792;
            training[3][ 20 ] =  0.0;
            training[3][ 21 ] =  0.0;
            training[3][ 22 ] =  1.4414332;
            training[3][ 23 ] =  1.8589462;
            training[3][ 24 ] =  0.0;
            training[3][ 25 ] =  0.43212885;
            training[3][ 26 ] =  2.267332;
            training[3][ 27 ] =  1.1610863;
            training[3][ 28 ] =  0.0;
            training[3][ 29 ] =  1.2600656;
            training[3][ 30 ] =  0.0;
            training[3][ 31 ] =  0.11712992;
            training[3][ 32 ] =  0.4310727;
            training[3][ 33 ] =  0.0;
            training[3][ 34 ] =  0.0;
            training[3][ 35 ] =  0.0;
            training[3][ 36 ] =  0.0;
            training[3][ 37 ] =  1.6918187;
            training[3][ 38 ] =  0.0;
            training[3][ 39 ] =  0.0;
            training[3][ 40 ] =  0.0;
            training[3][ 41 ] =  0.0;
            training[3][ 42 ] =  1.4109123;
            training[3][ 43 ] =  1.3766583;
            training[3][ 44 ] =  0.0;
            training[3][ 45 ] =  1.8565314;
            training[3][ 46 ] =  2.085095;
            training[3][ 47 ] =  0.0;
            training[3][ 48 ] =  0.59696394;
            training[3][ 49 ] =  1.301408;
            training[3][ 50 ] =  1.2632854;
            training[3][ 51 ] =  0.36720967;
            training[3][ 52 ] =  0.0;
            training[3][ 53 ] =  0.0;
            training[3][ 54 ] =  0.69752216;
            training[3][ 55 ] =  1.4342992;
            training[3][ 56 ] =  0.0;
            training[3][ 57 ] =  0.09837275;
            training[3][ 58 ] =  2.0359855;
            training[3][ 59 ] =  0.6657598;
            training[3][ 60 ] =  0.0;
            training[3][ 61 ] =  1.0964285;
            training[3][ 62 ] =  0.0;
            training[3][ 63 ] =  0.6719787;
            training[3][ 64 ] =  0.7931198;
            training[3][ 65 ] =  0.0;
            training[3][ 66 ] =  0.0;
            training[3][ 67 ] =  1.2588441;
            training[3][ 68 ] =  0.0;
            training[3][ 69 ] =  2.5209298;
            training[3][ 70 ] =  0.0;
            training[3][ 71 ] =  0.0;
            training[3][ 72 ] =  0.0;
            training[3][ 73 ] =  0.0;
            training[3][ 74 ] =  4.8007784;
            training[3][ 75 ] =  2.691891;
            training[3][ 76 ] =  0.0;
            training[3][ 77 ] =  1.6136796;
            training[3][ 78 ] =  3.7590876;
            training[3][ 79 ] =  0.0;
            training[3][ 80 ] =  0.9044039;
            training[3][ 81 ] =  3.5514195;
            training[3][ 82 ] =  1.0521995;
            training[3][ 83 ] =  1.0467353;
            training[3][ 84 ] =  0.0;
            training[3][ 85 ] =  0.0;
            training[3][ 86 ] =  0.0;
            training[3][ 87 ] =  0.7729126;
            training[3][ 88 ] =  0.0;
            training[3][ 89 ] =  0.48792425;
            training[3][ 90 ] =  0.5207541;
            training[3][ 91 ] =  0.9169843;
            training[3][ 92 ] =  0.0;
            training[3][ 93 ] =  0.10120964;
            training[3][ 94 ] =  0.0;
            training[3][ 95 ] =  1.4953865;
            training[4][ 0 ] =  0.0;
            training[4][ 1 ] =  0.0;
            training[4][ 2 ] =  0.0;
            training[4][ 3 ] =  0.0;
            training[4][ 4 ] =  0.0;
            training[4][ 5 ] =  0.31987876;
            training[4][ 6 ] =  0.0;
            training[4][ 7 ] =  0.0;
            training[4][ 8 ] =  0.0;
            training[4][ 9 ] =  0.0;
            training[4][ 10 ] =  1.4030054;
            training[4][ 11 ] =  0.8988409;
            training[4][ 12 ] =  0.0;
            training[4][ 13 ] =  1.2168691;
            training[4][ 14 ] =  1.1880006;
            training[4][ 15 ] =  0.0;
            training[4][ 16 ] =  0.7480902;
            training[4][ 17 ] =  0.5135374;
            training[4][ 18 ] =  0.7677679;
            training[4][ 19 ] =  0.0;
            training[4][ 20 ] =  0.0;
            training[4][ 21 ] =  0.0;
            training[4][ 22 ] =  2.290632;
            training[4][ 23 ] =  1.8362372;
            training[4][ 24 ] =  0.0;
            training[4][ 25 ] =  0.53273356;
            training[4][ 26 ] =  1.5157351;
            training[4][ 27 ] =  0.5483825;
            training[4][ 28 ] =  0.0;
            training[4][ 29 ] =  0.52331066;
            training[4][ 30 ] =  0.0;
            training[4][ 31 ] =  0.0;
            training[4][ 32 ] =  0.5863151;
            training[4][ 33 ] =  0.0;
            training[4][ 34 ] =  0.0;
            training[4][ 35 ] =  0.0;
            training[4][ 36 ] =  0.0;
            training[4][ 37 ] =  0.3846237;
            training[4][ 38 ] =  0.0;
            training[4][ 39 ] =  0.0;
            training[4][ 40 ] =  0.0;
            training[4][ 41 ] =  0.0;
            training[4][ 42 ] =  0.0;
            training[4][ 43 ] =  0.33577713;
            training[4][ 44 ] =  0.0;
            training[4][ 45 ] =  1.9154804;
            training[4][ 46 ] =  0.65414965;
            training[4][ 47 ] =  0.0;
            training[4][ 48 ] =  0.74048513;
            training[4][ 49 ] =  0.9763073;
            training[4][ 50 ] =  1.1102061;
            training[4][ 51 ] =  0.4424119;
            training[4][ 52 ] =  0.0;
            training[4][ 53 ] =  0.0;
            training[4][ 54 ] =  1.9125142;
            training[4][ 55 ] =  1.5074385;
            training[4][ 56 ] =  0.0;
            training[4][ 57 ] =  0.4331271;
            training[4][ 58 ] =  2.489251;
            training[4][ 59 ] =  0.9294312;
            training[4][ 60 ] =  0.0;
            training[4][ 61 ] =  1.5925182;
            training[4][ 62 ] =  0.0;
            training[4][ 63 ] =  0.19975674;
            training[4][ 64 ] =  0.0;
            training[4][ 65 ] =  0.0;
            training[4][ 66 ] =  0.0;
            training[4][ 67 ] =  0.2663772;
            training[4][ 68 ] =  0.0;
            training[4][ 69 ] =  0.53758043;
            training[4][ 70 ] =  0.0;
            training[4][ 71 ] =  0.0;
            training[4][ 72 ] =  0.0;
            training[4][ 73 ] =  0.0;
            training[4][ 74 ] =  3.0188632;
            training[4][ 75 ] =  1.058633;
            training[4][ 76 ] =  0.0;
            training[4][ 77 ] =  0.86154914;
            training[4][ 78 ] =  1.2320846;
            training[4][ 79 ] =  0.0;
            training[4][ 80 ] =  0.58939046;
            training[4][ 81 ] =  1.4578509;
            training[4][ 82 ] =  0.3294212;
            training[4][ 83 ] =  0.84600735;
            training[4][ 84 ] =  0.0;
            training[4][ 85 ] =  0.0;
            training[4][ 86 ] =  2.4267697;
            training[4][ 87 ] =  1.6748093;
            training[4][ 88 ] =  0.0;
            training[4][ 89 ] =  0.51631004;
            training[4][ 90 ] =  0.6311717;
            training[4][ 91 ] =  2.344007;
            training[4][ 92 ] =  0.0;
            training[4][ 93 ] =  0.43605995;
            training[4][ 94 ] =  0.0;
            training[4][ 95 ] =  0.98570734;
            training[5][ 0 ] =  0.49890918;
            training[5][ 1 ] =  0.0;
            training[5][ 2 ] =  0.0;
            training[5][ 3 ] =  0.0;
            training[5][ 4 ] =  0.0;
            training[5][ 5 ] =  0.31228417;
            training[5][ 6 ] =  0.0;
            training[5][ 7 ] =  0.0;
            training[5][ 8 ] =  0.0;
            training[5][ 9 ] =  0.0;
            training[5][ 10 ] =  1.1014373;
            training[5][ 11 ] =  1.350907;
            training[5][ 12 ] =  0.0;
            training[5][ 13 ] =  1.4800854;
            training[5][ 14 ] =  1.4039513;
            training[5][ 15 ] =  0.0;
            training[5][ 16 ] =  0.46541804;
            training[5][ 17 ] =  0.035782814;
            training[5][ 18 ] =  0.86205673;
            training[5][ 19 ] =  0.0;
            training[5][ 20 ] =  0.0;
            training[5][ 21 ] =  0.0;
            training[5][ 22 ] =  1.8209856;
            training[5][ 23 ] =  1.2798256;
            training[5][ 24 ] =  0.0;
            training[5][ 25 ] =  0.6711182;
            training[5][ 26 ] =  1.896535;
            training[5][ 27 ] =  0.33325815;
            training[5][ 28 ] =  0.0;
            training[5][ 29 ] =  0.25403333;
            training[5][ 30 ] =  0.0;
            training[5][ 31 ] =  0.0;
            training[5][ 32 ] =  0.41128486;
            training[5][ 33 ] =  0.0;
            training[5][ 34 ] =  0.0;
            training[5][ 35 ] =  0.0;
            training[5][ 36 ] =  0.0;
            training[5][ 37 ] =  0.18647343;
            training[5][ 38 ] =  0.0;
            training[5][ 39 ] =  0.0;
            training[5][ 40 ] =  0.0;
            training[5][ 41 ] =  0.0;
            training[5][ 42 ] =  0.8501301;
            training[5][ 43 ] =  0.11502227;
            training[5][ 44 ] =  0.0;
            training[5][ 45 ] =  1.9035957;
            training[5][ 46 ] =  0.077816844;
            training[5][ 47 ] =  0.0;
            training[5][ 48 ] =  1.0214114;
            training[5][ 49 ] =  0.9882176;
            training[5][ 50 ] =  1.2605277;
            training[5][ 51 ] =  0.07790065;
            training[5][ 52 ] =  0.0;
            training[5][ 53 ] =  0.0;
            training[5][ 54 ] =  1.8058186;
            training[5][ 55 ] =  0.91557574;
            training[5][ 56 ] =  0.0;
            training[5][ 57 ] =  0.66245633;
            training[5][ 58 ] =  2.2802749;
            training[5][ 59 ] =  0.9047046;
            training[5][ 60 ] =  0.0;
            training[5][ 61 ] =  2.2603016;
            training[5][ 62 ] =  0.0;
            training[5][ 63 ] =  0.2851473;
            training[5][ 64 ] =  0.0;
            training[5][ 65 ] =  0.0;
            training[5][ 66 ] =  0.0;
            training[5][ 67 ] =  0.06630468;
            training[5][ 68 ] =  0.0;
            training[5][ 69 ] =  1.0012312;
            training[5][ 70 ] =  0.0;
            training[5][ 71 ] =  0.0;
            training[5][ 72 ] =  0.0;
            training[5][ 73 ] =  0.0;
            training[5][ 74 ] =  7.365668;
            training[5][ 75 ] =  2.3563654;
            training[5][ 76 ] =  0.0;
            training[5][ 77 ] =  0.0;
            training[5][ 78 ] =  2.6916647;
            training[5][ 79 ] =  0.0;
            training[5][ 80 ] =  0.48368067;
            training[5][ 81 ] =  1.1530778;
            training[5][ 82 ] =  0.45027286;
            training[5][ 83 ] =  0.0;
            training[5][ 84 ] =  0.0;
            training[5][ 85 ] =  0.0;
            training[5][ 86 ] =  1.4791884;
            training[5][ 87 ] =  0.8298547;
            training[5][ 88 ] =  0.0;
            training[5][ 89 ] =  1.3303931;
            training[5][ 90 ] =  0.0;
            training[5][ 91 ] =  0.9724016;
            training[5][ 92 ] =  0.0;
            training[5][ 93 ] =  0.0;
            training[5][ 94 ] =  0.0;
            training[5][ 95 ] =  0.8516512;
            training[6][ 0 ] =  0.53776795;
            training[6][ 1 ] =  0.0;
            training[6][ 2 ] =  0.0;
            training[6][ 3 ] =  0.41082096;
            training[6][ 4 ] =  0.0;
            training[6][ 5 ] =  0.8934943;
            training[6][ 6 ] =  0.0;
            training[6][ 7 ] =  0.0;
            training[6][ 8 ] =  0.0;
            training[6][ 9 ] =  0.0;
            training[6][ 10 ] =  0.6803409;
            training[6][ 11 ] =  0.5421015;
            training[6][ 12 ] =  0.0;
            training[6][ 13 ] =  1.6185753;
            training[6][ 14 ] =  1.1731393;
            training[6][ 15 ] =  0.0;
            training[6][ 16 ] =  0.37057132;
            training[6][ 17 ] =  1.5774558;
            training[6][ 18 ] =  0.80836594;
            training[6][ 19 ] =  1.463579;
            training[6][ 20 ] =  0.0;
            training[6][ 21 ] =  0.0;
            training[6][ 22 ] =  1.7953687;
            training[6][ 23 ] =  1.4274248;
            training[6][ 24 ] =  0.0;
            training[6][ 25 ] =  0.36935788;
            training[6][ 26 ] =  2.3923678;
            training[6][ 27 ] =  2.3224447;
            training[6][ 28 ] =  0.0;
            training[6][ 29 ] =  2.108954;
            training[6][ 30 ] =  0.0;
            training[6][ 31 ] =  0.8743139;
            training[6][ 32 ] =  0.6796824;
            training[6][ 33 ] =  0.0;
            training[6][ 34 ] =  0.0;
            training[6][ 35 ] =  0.1884768;
            training[6][ 36 ] =  0.0;
            training[6][ 37 ] =  0.67504805;
            training[6][ 38 ] =  0.0;
            training[6][ 39 ] =  0.0;
            training[6][ 40 ] =  0.0;
            training[6][ 41 ] =  0.0;
            training[6][ 42 ] =  0.9441061;
            training[6][ 43 ] =  0.79701245;
            training[6][ 44 ] =  0.0;
            training[6][ 45 ] =  1.8775926;
            training[6][ 46 ] =  1.9840173;
            training[6][ 47 ] =  0.0;
            training[6][ 48 ] =  0.37551403;
            training[6][ 49 ] =  1.4183048;
            training[6][ 50 ] =  0.9275647;
            training[6][ 51 ] =  1.6430821;
            training[6][ 52 ] =  0.0;
            training[6][ 53 ] =  0.0;
            training[6][ 54 ] =  1.2082525;
            training[6][ 55 ] =  1.7539583;
            training[6][ 56 ] =  0.0;
            training[6][ 57 ] =  0.5992441;
            training[6][ 58 ] =  2.3218763;
            training[6][ 59 ] =  1.719348;
            training[6][ 60 ] =  0.0;
            training[6][ 61 ] =  1.589152;
            training[6][ 62 ] =  0.0;
            training[6][ 63 ] =  0.37402564;
            training[6][ 64 ] =  0.0;
            training[6][ 65 ] =  0.0;
            training[6][ 66 ] =  0.0;
            training[6][ 67 ] =  1.2096882;
            training[6][ 68 ] =  0.0;
            training[6][ 69 ] =  1.3673925;
            training[6][ 70 ] =  0.0;
            training[6][ 71 ] =  0.0;
            training[6][ 72 ] =  0.0;
            training[6][ 73 ] =  0.0;
            training[6][ 74 ] =  3.7020147;
            training[6][ 75 ] =  1.0015597;
            training[6][ 76 ] =  0.0;
            training[6][ 77 ] =  1.1454381;
            training[6][ 78 ] =  0.35105252;
            training[6][ 79 ] =  0.0;
            training[6][ 80 ] =  0.7422212;
            training[6][ 81 ] =  2.3215148;
            training[6][ 82 ] =  1.0266922;
            training[6][ 83 ] =  0.6027565;
            training[6][ 84 ] =  0.0;
            training[6][ 85 ] =  0.0;
            training[6][ 86 ] =  1.101306;
            training[6][ 87 ] =  0.014128208;
            training[6][ 88 ] =  0.0;
            training[6][ 89 ] =  0.92416924;
            training[6][ 90 ] =  0.90513027;
            training[6][ 91 ] =  2.4931133;
            training[6][ 92 ] =  0.0;
            training[6][ 93 ] =  2.986218;
            training[6][ 94 ] =  0.0;
            training[6][ 95 ] =  2.013473;
            training[7][ 0 ] =  0.0;
            training[7][ 1 ] =  0.0;
            training[7][ 2 ] =  0.0;
            training[7][ 3 ] =  0.0;
            training[7][ 4 ] =  0.0;
            training[7][ 5 ] =  0.663987;
            training[7][ 6 ] =  0.0;
            training[7][ 7 ] =  0.0;
            training[7][ 8 ] =  0.0;
            training[7][ 9 ] =  0.0;
            training[7][ 10 ] =  0.31456068;
            training[7][ 11 ] =  0.4408109;
            training[7][ 12 ] =  0.0;
            training[7][ 13 ] =  1.5726619;
            training[7][ 14 ] =  0.57735884;
            training[7][ 15 ] =  0.0;
            training[7][ 16 ] =  0.78228587;
            training[7][ 17 ] =  0.993554;
            training[7][ 18 ] =  0.7247913;
            training[7][ 19 ] =  0.4938097;
            training[7][ 20 ] =  0.0;
            training[7][ 21 ] =  0.0;
            training[7][ 22 ] =  2.6981769;
            training[7][ 23 ] =  1.7729414;
            training[7][ 24 ] =  0.0;
            training[7][ 25 ] =  0.32217056;
            training[7][ 26 ] =  2.3025815;
            training[7][ 27 ] =  1.833713;
            training[7][ 28 ] =  0.0;
            training[7][ 29 ] =  2.021355;
            training[7][ 30 ] =  0.0;
            training[7][ 31 ] =  0.7374674;
            training[7][ 32 ] =  1.0207841;
            training[7][ 33 ] =  0.0;
            training[7][ 34 ] =  0.0;
            training[7][ 35 ] =  0.6245675;
            training[7][ 36 ] =  0.0;
            training[7][ 37 ] =  1.2709886;
            training[7][ 38 ] =  0.0;
            training[7][ 39 ] =  0.0;
            training[7][ 40 ] =  0.0;
            training[7][ 41 ] =  0.0;
            training[7][ 42 ] =  1.7994256;
            training[7][ 43 ] =  1.3678167;
            training[7][ 44 ] =  0.0;
            training[7][ 45 ] =  1.5986644;
            training[7][ 46 ] =  2.727394;
            training[7][ 47 ] =  0.0;
            training[7][ 48 ] =  0.06065931;
            training[7][ 49 ] =  1.6824446;
            training[7][ 50 ] =  0.9322659;
            training[7][ 51 ] =  1.9008056;
            training[7][ 52 ] =  0.0;
            training[7][ 53 ] =  0.0;
            training[7][ 54 ] =  0.6438848;
            training[7][ 55 ] =  1.6550043;
            training[7][ 56 ] =  0.0;
            training[7][ 57 ] =  0.37504438;
            training[7][ 58 ] =  2.1503444;
            training[7][ 59 ] =  1.862539;
            training[7][ 60 ] =  0.0;
            training[7][ 61 ] =  1.5705701;
            training[7][ 62 ] =  0.0;
            training[7][ 63 ] =  0.2659235;
            training[7][ 64 ] =  2.039678;
            training[7][ 65 ] =  0.11331944;
            training[7][ 66 ] =  1.3496735;
            training[7][ 67 ] =  1.6486734;
            training[7][ 68 ] =  1.8213145;
            training[7][ 69 ] =  1.0251255;
            training[7][ 70 ] =  0.0;
            training[7][ 71 ] =  0.0;
            training[7][ 72 ] =  0.0;
            training[7][ 73 ] =  0.009049007;
            training[7][ 74 ] =  0.19643244;
            training[7][ 75 ] =  0.7227336;
            training[7][ 76 ] =  0.0;
            training[7][ 77 ] =  2.321944;
            training[7][ 78 ] =  2.5732322;
            training[7][ 79 ] =  0.0;
            training[7][ 80 ] =  0.0;
            training[7][ 81 ] =  2.3947258;
            training[7][ 82 ] =  1.0197991;
            training[7][ 83 ] =  3.340733;
            training[7][ 84 ] =  0.0;
            training[7][ 85 ] =  2.402991;
            training[7][ 86 ] =  0.18773091;
            training[7][ 87 ] =  1.6812022;
            training[7][ 88 ] =  0.0;
            training[7][ 89 ] =  0.11165057;
            training[7][ 90 ] =  3.1588066;
            training[7][ 91 ] =  2.706769;
            training[7][ 92 ] =  0.0;
            training[7][ 93 ] =  2.452242;
            training[7][ 94 ] =  0.0;
            training[7][ 95 ] =  0.25254655;
            training[8][ 0 ] =  0.0;
            training[8][ 1 ] =  0.0;
            training[8][ 2 ] =  0.100310564;
            training[8][ 3 ] =  0.750831;
            training[8][ 4 ] =  0.23913312;
            training[8][ 5 ] =  0.096832514;
            training[8][ 6 ] =  0.0;
            training[8][ 7 ] =  0.0;
            training[8][ 8 ] =  0.0;
            training[8][ 9 ] =  0.0;
            training[8][ 10 ] =  0.0;
            training[8][ 11 ] =  0.0;
            training[8][ 12 ] =  0.0;
            training[8][ 13 ] =  1.2515241;
            training[8][ 14 ] =  0.0;
            training[8][ 15 ] =  0.0;
            training[8][ 16 ] =  0.65937126;
            training[8][ 17 ] =  1.2507777;
            training[8][ 18 ] =  0.62060773;
            training[8][ 19 ] =  0.81029034;
            training[8][ 20 ] =  0.0;
            training[8][ 21 ] =  0.0;
            training[8][ 22 ] =  4.1486588;
            training[8][ 23 ] =  1.4034791;
            training[8][ 24 ] =  0.020884927;
            training[8][ 25 ] =  0.6409513;
            training[8][ 26 ] =  2.496435;
            training[8][ 27 ] =  3.3193808;
            training[8][ 28 ] =  0.0;
            training[8][ 29 ] =  3.3781538;
            training[8][ 30 ] =  0.0;
            training[8][ 31 ] =  1.4928741;
            training[8][ 32 ] =  0.054682434;
            training[8][ 33 ] =  0.0;
            training[8][ 34 ] =  0.0;
            training[8][ 35 ] =  0.0;
            training[8][ 36 ] =  0.0;
            training[8][ 37 ] =  0.019649029;
            training[8][ 38 ] =  0.0;
            training[8][ 39 ] =  0.0;
            training[8][ 40 ] =  0.0;
            training[8][ 41 ] =  0.0;
            training[8][ 42 ] =  0.0;
            training[8][ 43 ] =  0.0;
            training[8][ 44 ] =  0.0;
            training[8][ 45 ] =  1.6671014;
            training[8][ 46 ] =  0.0;
            training[8][ 47 ] =  0.0;
            training[8][ 48 ] =  1.14074;
            training[8][ 49 ] =  1.4752028;
            training[8][ 50 ] =  0.9468895;
            training[8][ 51 ] =  0.20114017;
            training[8][ 52 ] =  0.0;
            training[8][ 53 ] =  0.0;
            training[8][ 54 ] =  2.963605;
            training[8][ 55 ] =  1.4593968;
            training[8][ 56 ] =  0.0;
            training[8][ 57 ] =  0.4421139;
            training[8][ 58 ] =  2.487212;
            training[8][ 59 ] =  1.742836;
            training[8][ 60 ] =  0.0;
            training[8][ 61 ] =  2.341564;
            training[8][ 62 ] =  0.0;
            training[8][ 63 ] =  0.570104;
            training[8][ 64 ] =  0.0;
            training[8][ 65 ] =  0.0;
            training[8][ 66 ] =  0.0;
            training[8][ 67 ] =  0.1857264;
            training[8][ 68 ] =  0.0;
            training[8][ 69 ] =  1.3388727;
            training[8][ 70 ] =  0.0;
            training[8][ 71 ] =  0.0;
            training[8][ 72 ] =  0.0;
            training[8][ 73 ] =  0.0;
            training[8][ 74 ] =  6.5764165;
            training[8][ 75 ] =  2.6635358;
            training[8][ 76 ] =  0.0;
            training[8][ 77 ] =  0.44911814;
            training[8][ 78 ] =  3.6401916;
            training[8][ 79 ] =  0.0;
            training[8][ 80 ] =  0.2980018;
            training[8][ 81 ] =  1.7823889;
            training[8][ 82 ] =  0.3543062;
            training[8][ 83 ] =  0.91627836;
            training[8][ 84 ] =  0.0;
            training[8][ 85 ] =  0.0;
            training[8][ 86 ] =  0.3389542;
            training[8][ 87 ] =  1.2622486;
            training[8][ 88 ] =  0.0;
            training[8][ 89 ] =  0.9869686;
            training[8][ 90 ] =  0.0;
            training[8][ 91 ] =  1.1029665;
            training[8][ 92 ] =  0.0;
            training[8][ 93 ] =  0.0;
            training[8][ 94 ] =  0.0;
            training[8][ 95 ] =  0.7513708;
            training[9][ 0 ] =  0.926754;
            training[9][ 1 ] =  0.0;
            training[9][ 2 ] =  0.0;
            training[9][ 3 ] =  0.041611195;
            training[9][ 4 ] =  0.0;
            training[9][ 5 ] =  0.7793167;
            training[9][ 6 ] =  0.0;
            training[9][ 7 ] =  0.0;
            training[9][ 8 ] =  0.0;
            training[9][ 9 ] =  0.0;
            training[9][ 10 ] =  0.85084724;
            training[9][ 11 ] =  0.8864503;
            training[9][ 12 ] =  0.0;
            training[9][ 13 ] =  1.796611;
            training[9][ 14 ] =  1.6932843;
            training[9][ 15 ] =  0.0;
            training[9][ 16 ] =  0.34776986;
            training[9][ 17 ] =  1.4059839;
            training[9][ 18 ] =  0.90143234;
            training[9][ 19 ] =  1.504709;
            training[9][ 20 ] =  0.0;
            training[9][ 21 ] =  0.0;
            training[9][ 22 ] =  1.3594313;
            training[9][ 23 ] =  1.43325;
            training[9][ 24 ] =  0.0;
            training[9][ 25 ] =  0.35322243;
            training[9][ 26 ] =  2.388419;
            training[9][ 27 ] =  1.6817913;
            training[9][ 28 ] =  0.0;
            training[9][ 29 ] =  1.6185355;
            training[9][ 30 ] =  0.0;
            training[9][ 31 ] =  0.3789873;
            training[9][ 32 ] =  0.8471611;
            training[9][ 33 ] =  0.0;
            training[9][ 34 ] =  0.0;
            training[9][ 35 ] =  1.3609071;
            training[9][ 36 ] =  0.5386939;
            training[9][ 37 ] =  1.4138615;
            training[9][ 38 ] =  0.0;
            training[9][ 39 ] =  0.0;
            training[9][ 40 ] =  0.0;
            training[9][ 41 ] =  0.0;
            training[9][ 42 ] =  1.3710061;
            training[9][ 43 ] =  1.0084807;
            training[9][ 44 ] =  0.0;
            training[9][ 45 ] =  1.9192452;
            training[9][ 46 ] =  2.1307986;
            training[9][ 47 ] =  0.0;
            training[9][ 48 ] =  0.4565128;
            training[9][ 49 ] =  2.2410448;
            training[9][ 50 ] =  0.78778315;
            training[9][ 51 ] =  2.1503181;
            training[9][ 52 ] =  0.0;
            training[9][ 53 ] =  0.0;
            training[9][ 54 ] =  0.83238447;
            training[9][ 55 ] =  1.7040293;
            training[9][ 56 ] =  0.0;
            training[9][ 57 ] =  0.007147327;
            training[9][ 58 ] =  2.1612642;
            training[9][ 59 ] =  2.5349388;
            training[9][ 60 ] =  0.0;
            training[9][ 61 ] =  1.8899455;
            training[9][ 62 ] =  0.0;
            training[9][ 63 ] =  0.9446115;
            training[9][ 64 ] =  0.0;
            training[9][ 65 ] =  0.0;
            training[9][ 66 ] =  0.0;
            training[9][ 67 ] =  0.81887317;
            training[9][ 68 ] =  0.0;
            training[9][ 69 ] =  0.0;
            training[9][ 70 ] =  0.0;
            training[9][ 71 ] =  0.0;
            training[9][ 72 ] =  0.0;
            training[9][ 73 ] =  0.0;
            training[9][ 74 ] =  1.2885363;
            training[9][ 75 ] =  0.0;
            training[9][ 76 ] =  0.0;
            training[9][ 77 ] =  0.5750258;
            training[9][ 78 ] =  0.0;
            training[9][ 79 ] =  0.0;
            training[9][ 80 ] =  0.0;
            training[9][ 81 ] =  0.46559763;
            training[9][ 82 ] =  0.3886965;
            training[9][ 83 ] =  1.3439064;
            training[9][ 84 ] =  0.0;
            training[9][ 85 ] =  0.0;
            training[9][ 86 ] =  4.244321;
            training[9][ 87 ] =  1.5816512;
            training[9][ 88 ] =  0.0;
            training[9][ 89 ] =  0.98004377;
            training[9][ 90 ] =  1.6120588;
            training[9][ 91 ] =  3.5927734;
            training[9][ 92 ] =  0.0;
            training[9][ 93 ] =  3.6165903;
            training[9][ 94 ] =  0.0;
            training[9][ 95 ] =  0.7125958;

            
            //now we will train with each of the training sets:
            for (int tr = 0; tr < num_of_train; tr++){
                train(inputs, training[tr], true, 0.1);
            }
            
            double[] outputs = new double[height];
            int trac1 = 0;
            int trac2 = 0;
            
            for (int num = 0; num < 100; num++){
                Random rand = new Random();

		// Obtain a number between [0 - height-1].
		int index = rand.nextInt(height-1);
                
                //now change the input node at index index:
                inputs[index] = inputs[index] + 1;
                
                //now run the network:
                outputs = run_net(inputs);
                
                for (int i = 0; i < height; i++){
                    if (i < height/3){
                        trac2 = 0;
                        System.out.println("inputs[" + trac1 + "][" + trac2 + "][" + i + "] = " + outputs[i]);
                    }
                    else if (i >= height/3 && i < 2*height/3){
                        trac2 = 1;
                        System.out.println("inputs[" + trac1 + "][" + trac2 + "][" + (i-height/3) + "] = " + outputs[i]);
                    }
                    else{
                        trac2 = 2;
                        System.out.println("inputs[" + trac1 + "][" + trac2 + "][" + (i-(2*height/3)) + "] = " + outputs[i]);
                    }
                
                } 
                trac1++;
                    
                
            }
        
        }
      
        public static double[] setup(){
            double[] out = new double[height*height*layers+3];
            for (int i = 0; i < height*height*layers+3; i ++){
                out[i] = random_number();
                //System.out.println(out[i]);
            }
            return out;
        }
        
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
           
        }
        
        public static double[] run_net (double[] inputs){
            
            double outputs[] = new double[height];
            double layer[][] = new double[height][layers];
            
            int trac1 = 0;
          
            
            //this method runs the network
            for (int i = 0; i < layers; i++){
                //for each layer, calc each neuron:
                for (int j = 0; j < height; j++){
                    //if it is the first time...
                    if (i == 0){
                        double output = 0;
            
                        for (int n = 0; n < height; n++){
                            output = output + weights[trac1]*inputs[n];
				
				trac1++;
                        }
                        
                        output = Math.pow(e, output) / (Math.pow(e, output) + 1); //sigmoid func

                        
                        layer[j][i] = output;
                        if (Double.isNaN(layer[j][i])){
                            layer[j][i] = 1E-3;
                        }
                    }
                    
                    //else if it is the last time...
                    else if (i == layers-1){
                        double output = 0;
            
                        for (int n = 0; n < height; n++){
                            output = output + weights[trac1]*layer[n][i-1];
				
                            trac1++;
                        }

                        //output = Math.pow(e, output) / (Math.pow(e, output) + 1); //sigmoid func

                        
                        layer[j][i] = output;
                        if (Double.isNaN(layer[j][i])){
                            layer[j][i] = 1E-3;
                        }
                        outputs[j] = layer[j][i];
                        
                        
                    }
                    
                    //else...
                    else {
                        double output = 0;
            
                        for (int n = 0; n < height; n++){
                            output = output + weights[trac1]*layer[n][i-1];
				trac1++;
				
                        }

                        output = Math.pow(e, output) / (Math.pow(e, output) + 1); //sigmoid func

                        
                        layer[j][i] = output;
                        if (Double.isNaN(layer[j][i])){
                            layer[j][i] = 1E-3;
                        }
                    }
                    
                    //System.out.println(layer[j][i]);
                    
                }
                
            }
            
            return outputs;
        }
    
        //fuction to genetrate random decimals
        public static double random_number(){
		Random rand = new Random();

		// Obtain a number between [0 - 199].
		double n = rand.nextInt(199);
		
		n = n/100;
		n = n - 1;
		return n;
        }
    
}
