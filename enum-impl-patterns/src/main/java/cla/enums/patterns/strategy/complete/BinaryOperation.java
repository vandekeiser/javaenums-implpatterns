package cla.enums.patterns.strategy.complete;

/**
 * Pattern "Strategy complete enum implementation".
 * <p>Dans ce pattern, il n'existe pas d'implémentations non-enums.
 * Si on a besoin d'une autre implémentation, on ajoute une constante à l'enum,
 * qui contient toutes les implémentations intéressantes de la stratégie connues/intéressantes (pour l'instant).
 * Les implémentations enum constants évitent la multiplication de singletons.</p>
 * <p>Ces enums sont typiquement stateless</p> 
 */
public interface BinaryOperation {
	
	double apply(double d1, double d2);
	
	public enum ArithmeticOperation implements BinaryOperation {
		
		PLUS("+") {
			@Override public double apply(double d1, double d2) {
				return d1 + d2;
			}
		},
		
		MINUS("-") {
			@Override public double apply(double d1, double d2) {
				return d1 - d2;
			}
		},
		
		TIMES("*") {
			@Override public double apply(double d1, double d2) {
				return d1 * d2;
			}
		},
		
		DIVIDED_BY("/") {
			@Override public double apply(double d1, double d2) {
				return d1 / d2;
			}
		},
		
		;
		
		private final String symbol;
		private ArithmeticOperation (String symbol) {this.symbol = symbol;}
		
		@Override public String toString() {
			return this.symbol;
		}
	}

}