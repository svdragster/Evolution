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
	
	
	
	private float[] weights = new float[2];
	
	private float learningRate = 0.01f;
	
	public Perceptron() {
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
	
	public void train(float[] inputs, int target) {
		int guess = guess(inputs);
		int error = target - guess;
		
		// change all the weights according to formula
		for (int i=0; i<weights.length; i++) {
			weights[i] += error * inputs[i] * learningRate;
		}
	}
}
