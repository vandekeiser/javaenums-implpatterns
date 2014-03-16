package cla.enums.patterns.with.values.one;

import java.io.Serializable;


/**
 * L'implémentation naïve du singleton offre moins de garanties que l'enum,
 * surtout pour un type sérialisable.
 */
public class NaiveSingleton implements Serializable {
	
	private NaiveSingleton() {}
	
	public static final NaiveSingleton instance = new NaiveSingleton(); 
	
}
