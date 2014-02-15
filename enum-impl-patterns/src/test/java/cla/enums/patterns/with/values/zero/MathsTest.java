package cla.enums.patterns.with.values.zero;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author CLA
 */
public class MathsTest {

	/**
	 * <p>Quand un test passe au vert alors qu'on n'a encore rien fait c'est que le test ne teste rien.</p>
	 * <p>C'est pour ça qu'il faut d'abord obtenir le rouge avant d'implémenter.</p>
	 * <p>Ici le test est trompeur aussi pour une autre raison, voyez-vous laquelle?</p>
	 */
	@Test public void cosinusAngleDroitEgaleZero() {
		assertEquals(
				0D, 
				Maths.cos(Maths.PI/2),
				0D
		);
	}
	
	/**
	 * Vous gagnez une citation si vous arrivez quand même à invoquer la méthode non-statique <code>toto()</code>
	 * (c'est difficile parce que les enums sont bien blindées).
	 */
	@Ignore //TODO
	@Test public void impossible() {
//		assertEquals(
//				999D, 
//				new Maths().toto(),
//				0D
//		);
	}

}
