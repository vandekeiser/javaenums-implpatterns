package cla.enums.patterns.with.di.model;

/**
 * Comme expliqué dans <tt>Bill</tt>, en Java on utilise souvent l'inversion de 
 * dépendance dans des enums polymorphiques et en particulier celles dont 
 * les constantes représentent les implémentations d'une Stratégie (GOF)
 * Ici shippingFeeForWeight dépend de l'abstraction <tt>ItemsEnvironment</tt> qui est dans 
 * le package <tt>model</tt>   
 * */
public enum ClientType {

	GOLD {
		@Override public long feeMultiplier() {
			return 1;
		}
	},
	
	SILVER {
		@Override public long feeMultiplier() {
			return 2;
		}
	},
	
	;
	
	public long shippingFeeForWeight(double weight, ItemsEnvironment env) {
		//C'est ici qu'on a besoin d'un composant "service", 
		// mais on pourrait aussi dépendre d'un Repository, ...
		//Cette nécessité se manifeste souvent quand on veut faire du domain-driven design.
		long baseFee = env.fees().baseShippingFee(weight);
		return baseFee * feeMultiplier();
	}

	protected abstract long feeMultiplier();
}
