package cla.enums.patterns.with.di.model;

/**
 * Une entité du domaine.
 * <p>
 * Elle colocalise état et logique métier,
 * contrairement à l'antipattern fréquent des "entités étiques" (squelettiques).
 * Le livre "domain-driven design" décrit cet l'antipattern dans lequel
 * les entités ressemblent à des structs sans logique métier,
 * qui est alors principalement contenue dans des "transaction scripts"
 * (typiquement de longues méthodes procédurales dans un composant "frontière",
 * comme un web service, un EJB remote, un bean Spring transactionnel, ...)
 * </p>
 * <p>
 * L'inconvénient principal de cet antipattern est que comme la couche objet n'a pas d'épaisseur,
 * on perd tous les avantages de la modélisation objet.
 * </p>
 * <p>
 * Le livre explique en outre que la fréquence de cet antipattern s'explique 
 * par une difficulté technique: la plupart du temps, pour réaliser une logique métier non-triviale,
 * les objets du domaine auraient besoin de dépendre de composants techniques ou frontière
 * (frontière au sens de boundary du pattern EE entity/control/boundary).
 * Ceci serait problématique, car d'autre part les composants frontière dépendent toujours 
 * des entités du domaine; on aboutirait alors à une dépendance croisée entre les packages
 * <tt>cla.enums.patterns.with.polymorphism.and.di.model</tt> et 
 * <tt>cla.enums.patterns.with.polymorphism.and.di.services</tt>.
 * La façon la plus simple mais pas la meilleure de s'affranchir de cette difficulté
 * est de mettre toute la logique métier dans les composants frontière,
 * et on arrive alors à l'antipattern décrit.     
 * </p>
 * <p>
 * Une solution plus satisfaisante est d'utiliser l'inversion de dépendance, 
 * qui consiste à remplacer la dépendance entre deux packages par une dépendance
 * des deux envers une abstraction commune, contenue dans le package métier
 * (ici cette abstraction est ItemsEnvironment).
 * </p>
 * <p>
 * En particulier en Java, on est souvent amené à utiliser cette technique 
 * avec des enums polymorphiques dont les constantes représentent les 
 * implémentations d'une Stratégie (GOF), ici ClientType.  
 * </p>       
 */
//@Entity //Les entités JPA sont un exemple typique d'entités du domaine. 
public class Bill {
	
	//@Field
	Item billedItem;
	
	//@Field, les enums sont persistées sans problème par JPA 
	// (de prference par leur name et non leur ordinal)
	ClientType billedClientType;
	
	//Implémente une logique métier non triviale,
	// mais pour ce faire à besoin d'un service externe technique/frontière.
	// Ici la logique métier est localisée dans l'enum "Stratégie" ClientType.
	//(Rien à voir, mais on ne fait jamais de calcul exacts (monétaires ou autre) avec des types binaires,
	// ici on représente la quantité monétaire en centimes (de quelle monnaie??) car ce n'est pas le sujet, 
	// mais une solution plus réaliste est d'utiliser le pattern Quantité)
	public long computeTotalPrice(ItemsEnvironment env) {
		return  billedItem.basePrice + this.billedClientType.shippingFeeForWeight(
			this.billedItem.weight, 
			env
		);
	}
	
}
