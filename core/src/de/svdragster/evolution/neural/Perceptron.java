package de.svdragster.evolution.neural;

import java.util.Random;

/**
 * Created by Sven on 18.12.2017.
 */
public class Perceptron {
	
	/*
	
	error = answer - guess;
	deltaWeight = error * input
	new weight = weight + error * input * learning rate
	
	
	 */
	
	public static Random random = new Random();
	
	
	
	private float[] weights;
	
	private float learningRate = 0.000001f;
	
	public Perceptron(int weightAmount) {
		weights = new float[weightAmount];
		for (int i=0; i<weights.length; i++) {
			weights[i] = random.nextFloat()*2-1;
		}
	}
	
	public int guess(float[] inputs) {
		float sum = 0;
		for (int i=0; i<weights.length; i++) {
			sum += inputs[i] * weights[i];
		}
		return (int) Math.signum(sum);
	}
	
	public float guessY(float x) {
		/*float m = weights[1] / weights[0];
		float b = weights[2];
		return m * x + b;*/
		float w0 = weights[0];
		float w1 = weights[1];
		float w2 = weights[2];
		
		return -(w2/w1) - (w0/w1) * x;
	}
	
	public void train(float[] inputs, int target) {
		int guess = guess(inputs);
		int error = target - guess;
		
		// change all the weights according to formula
		for (int i=0; i<weights.length; i++) {
			weights[i] += error * inputs[i] * learningRate;
		}
	}
}
