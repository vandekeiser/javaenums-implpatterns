package cla.enums.patterns.strategy.complete;

public enum Expressions implements Expression<Double> {
	
	LITERAL {
		@Override public Double evaluate(String doubleValue) {
			return Double.valueOf(doubleValue);
		}
	},
	
	;

}
