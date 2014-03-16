package cla.enums.patterns.with.di.model;


/**
 * Une entité du domaine.
 * Ici son seul intérêt dans l'exemple est d'être agrégée par <tt>Bill</tt>,
 * qui lui colocalise état et logique métier. 
 */
//@Entity
public class Item {

	public long priceWithoutShipping;
	
	public double weight;

}
