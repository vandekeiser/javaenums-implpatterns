package cla.enums.patterns.strategy.complete;

import org.junit.Test;
import static cla.enums.patterns.strategy.complete.BinaryOperation.ArithmeticOperation.*;
import static org.junit.Assert.assertEquals;

public class BinaryOperationTest {

	@Test public void plus() {
		assertEquals(
				3D, 
				PLUS.apply(1D, 2D),
				0D
		);
	}
	
	@Test public void minus() {
		assertEquals(
				-1D, 
				MINUS.apply(1D, 2D),
				0D
		);
	}
	
	@Test public void times() {
		assertEquals(
				6D, 
				TIMES.apply(2D, 3D),
				0D
		);
	}
	
	@Test public void dividedBy() {
		assertEquals(
				2D, 
				DIVIDED_BY.apply(6D, 3D),
				0D
		);
	}

	@Test public void printPlus() {
		assertEquals(
				"+", 
				PLUS.toString()
		);
	}
	
	@Test public void printMinus() {
		assertEquals(
				"-", 
				MINUS.toString()
		);
	}
	
	@Test public void printTimes() {
		assertEquals(
				"*", 
				TIMES.toString()
		);
	}
	
	@Test public void printDividedBy() {
		assertEquals(
				"/", 
				DIVIDED_BY.toString()
		);
	}
}
