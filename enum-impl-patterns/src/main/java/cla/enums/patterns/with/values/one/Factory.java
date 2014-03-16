package cla.enums.patterns.with.values.one;


/**
 * Un singleton stateless. 
 * Java Puzzlers suggère d'utiliser une enum pour être sûr à moindre frais
 * que cette enum en est vraiment une.
 */
public enum Factory {
	
	instance;

	public Object create() {
		return new Object();
	}
}
