package cla.enums.patterns.strategy.partial;


/**
 * Une entité du domaine
 */
public class Record {
	
	public boolean  logicallyDeleted; 
	
	//Example peu réaliste mais simple, car ce n'est pas le sujet; 
	//dans la réalité la suppression physique ne serait sûrement pas implémentée par un flag.
	public boolean physicallyDeleted;
	
}
