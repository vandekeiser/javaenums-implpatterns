package cla.enums.patterns.with.polymorphism.and.di.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cla.enums.patterns.with.polymorphism.and.di.services.ItemEnvironmentBean;

/**
 * Model layer test.
 * @author CLA  
 */
public class ItemsTest {

	//@Inject bean from technical services layer 
	ItemEnvironmentBean env = new ItemEnvironmentBean();
	
	//SUT = Model layer object
	private Bill bill;
	
	@Test public void totalPriceTakesBasePriceAndShippingFeeIntoAccount() {
		assertEquals(
			9.0D, //weight=2, base price=3*weight=6, total=6*1.5=9 
			bill.computeTotalPrice(this.env),
			0.0D //pr�cision OK pour les petits entiers
		);
	}

	//---setup/teardown
	@Before public void setup() {
		//1. Create bill
		this.bill = new Bill();
		bill.item = new Item();
		bill.item.weight = 2.0D;
		bill.shipping = ShippingFee.HEAVY;
		
		//2. Simule l'injection de dépendance
		env.basePrices = (double weight) -> 3*weight;
	}
	@After public void teardown() {
		this.bill = null;
	}
}
