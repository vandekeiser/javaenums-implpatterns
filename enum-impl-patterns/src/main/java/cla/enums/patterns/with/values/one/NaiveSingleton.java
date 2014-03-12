package cla.enums.patterns.with.values.one;

import java.io.Serializable;


/**
 * Ce singleton suffit l
 */
public class NaiveSingleton implements Serializable {
	
	private NaiveSingleton() {}
	
	public static final NaiveSingleton instance = new NaiveSingleton(); 
	
}
