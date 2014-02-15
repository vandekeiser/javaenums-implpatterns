package cla.enums.patterns.with.di.services;

public class ItemEnvironmentBean implements cla.enums.patterns.with.di.model.ItemsEnvironment {

	//@Inject
	public BasePriceServices basePrices = (double weight) -> 0D; 
	
	@Override public BasePriceServices basePriceServices() {
		return basePrices;
	}
	
}
