package cla.enums.patterns.with.values.one;


/**
 * Un singleton stateless.
 */
public enum Factory {
	
	instance;

	public Object create() {
		return new Object();
	}
}
