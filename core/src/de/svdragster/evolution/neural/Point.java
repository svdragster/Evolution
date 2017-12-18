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
	private int label;
	
	public Point() {
		x = Perceptron.random.nextFloat()*2-1;
		y = Perceptron.random.nextFloat()*2-1;
		
		if (x > y) {
			label = 1;
		} else {
			label = -1;
		}
	}
	
	public void show() {
		Main.instance.addDot(getX(), getY(), label);
	}
	
	public float getX() {
		return (x+1)*WIDTH/2;
	}
	
	public float getY() {
		return (y+1)*HEIGHT/2;
	}
	
	public int getLabel() {
		return label;
	}
}
