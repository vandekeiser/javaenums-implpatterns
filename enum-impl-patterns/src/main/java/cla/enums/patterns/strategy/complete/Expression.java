package cla.enums.patterns.strategy.complete;

public interface Expression<T> {

	T evaluate(String declaration);
	
}
