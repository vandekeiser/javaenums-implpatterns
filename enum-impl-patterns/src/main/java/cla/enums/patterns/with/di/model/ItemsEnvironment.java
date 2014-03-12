package cla.enums.patterns.with.di.model;


/**
 * L'abstraction commune dont dépendent: 
 * <ul>
 * <li>les entités du domaine et en particulier l'enum <tt>ClientType</tt>
 * <li>le bean d'implémentation technique du package <tt>services</tt>, <tt>ItemsEnvironmentBean</tt>
 * </ul>
 */
public interface ItemsEnvironment {

	/**
	 * Ici l'environnement ne comporte qu'1 service technique. 
	 * En réalité l'interface environnement pourrait exposer différents types de 
	 * composants stateless ou stateful sous une forme abstraite pour la couche métier. 
	 */
	BasePriceServices feeServices();

	/**
	 * L'abstraction d'un service technique (par exemple un WS)
	 */
	public interface BasePriceServices {
		long baseShippingFee(double weight);
	}
}
