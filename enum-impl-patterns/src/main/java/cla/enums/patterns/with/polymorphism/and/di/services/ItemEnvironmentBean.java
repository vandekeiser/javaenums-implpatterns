package cla.enums.patterns.with.polymorphism.and.di.services;

import cla.enums.patterns.with.polymorphism.and.di.model.ItemsEnvironment;

public class ItemEnvironmentBean implements ItemsEnvironment {

	//@Inject
	public BasePriceServices basePrices = (double weight) -> 0D; 
	
	@Override public BasePriceServices basePriceServices() {
		return basePrices;
	}
	
}
