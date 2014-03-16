package cla.enums.patterns.with.di.services;

/**
 * Bean Spring/EE dont ne veulent surtout pas dépendre les entités du domaine.
 * Elles ne dépendent que de ItemsEnvironment qui fait bien partie du package model.
 * */
public class ItemEnvironmentBean implements cla.enums.patterns.with.di.model.ItemsEnvironment {

	/**
	 * Ici le côté technique de la classe d'implémentation est illustré par une dépendance 
	 * à un service supposément technique, comme un WS remote par ex. 
	 * On le met public pour simuler un @Inject de framework à peu de frais depuis ItemsTest#setup().  
	 * */
	//@Inject
	public FeeServices feeServices;
	
	@Override public FeeServices fees() {
		return feeServices;
	}
	
}
