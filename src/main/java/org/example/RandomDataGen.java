package org.example;

import java.util.Random;

public class RandomDataGen {

    public  double[]  start(int number) {
        // Create an array to hold 1000 random double values
        double[] data = new double[number];

        // Create an instance of Random class
        Random random = new Random();

        // Fill the array with random double values
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextDouble() * 100; // Random doubles between 0.0 (inclusive) and 100.0 (exclusive)
        }

        return data;
    }
}
