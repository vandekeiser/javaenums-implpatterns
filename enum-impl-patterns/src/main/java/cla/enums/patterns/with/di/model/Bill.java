package cla.enums.patterns.with.di.model;

//@Entity
public class Bill {
	
	//@Field
	Item item;
	
	//@Field, les enums sont persistees sans problème par JPA/...
	ShippingFee shipping;
	
	public double computeTotalPrice(ItemsEnvironment env) {
		return this.shipping.shippingFee(
			this.item.weight, 
			env
		);
	}
	
}
