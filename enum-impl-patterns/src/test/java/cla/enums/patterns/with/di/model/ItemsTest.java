package cla.enums.patterns.with.di.model;

import cla.enums.patterns.with.di.services.ItemEnvironmentBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests unitaires de la couche métier.
 */
public class ItemsTest {

	//@Inject bean technique 
	private ItemEnvironmentBean env;
	
	//Le SUT
	private Bill bill;
	
	@Test public void totalPriceTakesBasePriceAndShippingFeeIntoAccount() {
		assertEquals(
			19.0D, //7 + (3*2)*2 
			bill.computeTotalPrice(this.env),
			0.0D //précision OK pour les petits entiers
		);
	}

	//---setup/teardown
	@Before public void setup() {
		//1. Create bill
		this.bill = new Bill();
		bill.billedItem = new Item();
		bill.billedItem.priceWithoutShipping = 7L;
		bill.billedItem.weight = 2.0D;
		bill.billedClientType = ClientType.SILVER;//*2
		
		//2. Simule l'injection de dépendance
        env = new ItemEnvironmentBean();
		env.feeServices = (double weight) -> 3*Math.round(weight);//3*2=6
	}
	@After public void teardown() {
        this.env = null;
        this.bill = null;
	}
}
