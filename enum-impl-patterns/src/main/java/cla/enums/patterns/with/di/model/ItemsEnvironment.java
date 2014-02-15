package cla.enums.patterns.with.di.model;


public interface ItemsEnvironment {

	BasePriceServices basePriceServices();

	public interface BasePriceServices {
		double basePrice(double weight);
	}
}
