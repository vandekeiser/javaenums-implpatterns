package cla.enums.patterns.with.di.services;

/**
 * C'est le package technique/frontière qui dépend du package métier (inversion de dépendance).
 * */
public class ItemEnvironmentBean implements cla.enums.patterns.with.di.model.ItemsEnvironment {

	//@Inject
	public BasePriceServices basePrices;
	
	@Override public BasePriceServices basePriceServices() {
		return basePrices;
	}
	
}
