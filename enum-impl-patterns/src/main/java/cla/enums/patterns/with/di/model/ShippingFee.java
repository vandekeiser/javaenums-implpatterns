package cla.enums.patterns.with.di.model;



public enum ShippingFee {

	LIGHT {
		@Override public double multiplier() {
			return 1.0D;
		}
	},
	
	HEAVY {
		@Override public double multiplier() {
			return 1.5D;
		}
	},
	
	;
	
	public double shippingFee(double weight, cla.enums.patterns.with.di.model.ItemsEnvironment env) {
		double basePrice = env.basePriceServices().basePrice(weight);
		return basePrice * multiplier();
	}

	protected abstract double multiplier();
}
