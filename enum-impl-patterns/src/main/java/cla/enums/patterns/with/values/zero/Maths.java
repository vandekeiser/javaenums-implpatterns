package cla.enums.patterns.with.values.zero;


/**
 * <p>Java n'a pas de "top-level static class" au sens de C#
 * (classes dont le compilateur s'assure que toutes les méthodes sont statiques)</p>
 * 
 * <p>L'enum sans valeurs est un pattern d'implémentation java qui émule ces classes
 * (qu'on pourrait facilement avoir en java dans un "coin 2" via un changement de javac,
 * mais les concepteurs de Java doivent avoir peur d'ajouter à la confusion qui entoure déjà les
 * nested classes statiques VS inner classes VS static class en C#).</p>
 * 
 * L'émulation n'est pas complète car on peut quand même écrire une méthode non-statique,
 * mais au runtime on est sûr de ne pas invoquer cette méthode.
 * Dans un sens, la garantie est même supérieure au pattern habituel:
 * <code>
 * private Math(){throw new AssertionError();}
 * </code>
 * qui permet de rentrer dans le constructeur (même si c'est pour crasher tt de suite), et qui est un peu plus verbeux.
 * 
 * @author CLA
 * 
 * */
public enum Maths {
	
	;//Une enum commence toujours par la déclaration de ses instances (les "enum constants");
	 //ici il n'y en a aucune mais le bloc est quand même obligatoire.
	
	public static double PI = 4*java.lang.Math.atan(1.0D);//tan(pi/4)=1 cf. le cercle trigonométrique
	
	public static double cos(double radians) {
		return 0D;//TODO
	} 
	
	//Impossible à appeler (à moins que??)
	public double toto() {return 999D;}
}
