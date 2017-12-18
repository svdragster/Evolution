package de.svdragster.evolution.util;

/**
 * Created by Sven on 18.12.2017.
 */
public class MathUtil {
	
	
	public static double sigmoid(double x) {
		if( x < -10 )
			return 0;
		else if( x > 10 )
			return 1;
		else
			return 1 / (1 + Math.exp(-x));
	}
	
}
