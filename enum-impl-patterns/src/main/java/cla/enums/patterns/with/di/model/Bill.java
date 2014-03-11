package cla.enums.patterns.with.di.model;

//@Entity
public class Bill {
	
	//@Field
	Item item;
	
	//@Field, les enums sont persistees sans problème par JPA/...
	ClientType weight;
	
	public double computeTotalPrice(ItemsEnvironment env) {
		return this.weight.shippingFee(
			this.item.weight, 
			env
		);
	}
	
}
