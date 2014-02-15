package cla.enums.patterns.with.di.model;

import cla.enums.patterns.with.di.services.ItemEnvironmentBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Model layer test.
 * @author CLA  
 */
public class ItemsTest {

	//@Inject bean from technical services layer 
	private ItemEnvironmentBean env;
	
	//SUT = Model layer object
	private Bill bill;
	
	@Test public void totalPriceTakesBasePriceAndShippingFeeIntoAccount() {
		assertEquals(
			9.0D, //weight=2, base price=3*weight=6, total=6*1.5=9 
			bill.computeTotalPrice(this.env),
			0.0D //précision OK pour les petits entiers
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
        env = new ItemEnvironmentBean();
		env.basePrices = (double weight) -> 3*weight;
	}
	@After public void teardown() {
        this.env = null;
        this.bill = null;
	}
}
