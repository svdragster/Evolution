package de.svdragster.evolution.neural;

import de.svdragster.evolution.Main;

/**
 * Created by Sven on 18.12.2017.
 */
public class Point {

	public static final float WIDTH = 500;
	public static final float HEIGHT = 500;
	
	private float x;
	private float y;
	private float bias;
	private int label;
	
	public Point() {
		x = Perceptron.random.nextFloat()*2.0f-1.0f;
		y = Perceptron.random.nextFloat()*2.0f-1.0f;
		bias = 1;
		
		float lineY = Main.instance.someFunction(x);
		
		if (y > lineY) {
			label = 1;
		} else {
			label = -1;
		}
	}
	
	public void show() {
		Main.instance.addDot(getMappedX(), getMappedY(), label);
	}
	
	public float getMappedX() {
		return (x+1)*WIDTH/2;
	}
	
	public float getMappedY() {
		return (y+1)*HEIGHT/2;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getLabel() {
		return label;
	}
	
	public float getBias() {
		return bias;
	}
}
