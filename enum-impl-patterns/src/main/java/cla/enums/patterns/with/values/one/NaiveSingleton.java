package cla.enums.patterns.with.values.one;

import java.io.Serializable;

public class NaiveSingleton implements Serializable {
	
	private NaiveSingleton() {}
	
	public static final NaiveSingleton instance = new NaiveSingleton(); 
	
}
