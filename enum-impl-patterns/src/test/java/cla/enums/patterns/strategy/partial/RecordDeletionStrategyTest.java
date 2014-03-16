package cla.enums.patterns.strategy.partial;

import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.DEFECTIVE;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.NOOP;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.UNSUPPORTIVE;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.WellKnownImpls.LOGICAL_DELETION;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.WellKnownImpls.PHYSICAL_DELETION;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecordDeletionStrategyTest {

	private Record r;
	private RecordEnvironment env;
	
	//Tests de la variante "implémentations dégénérées"
	@Test public void noop() {
		NOOP.deleteRecord(r, env);
		assertFalse(r.logicallyDeleted);
		assertFalse(r.physicallyDeleted);
	}
	
	@Test(expected=RuntimeException.class) public void defective() {
		DEFECTIVE.deleteRecord(r, env);
	}
	
	@Test(expected=UnsupportedOperationException.class) public void unsupportive() {
		UNSUPPORTIVE.deleteRecord(r, env);
	}
	
	//Tests de la variante "implémentations connues"
	@Test public void logical() {
		LOGICAL_DELETION.deleteRecord(r, env);
		assertTrue(r.logicallyDeleted);
		assertFalse(r.physicallyDeleted);
	}
	
	@Test public void physical() {
		PHYSICAL_DELETION.deleteRecord(r, env);
		assertFalse(r.logicallyDeleted);
		assertTrue(r.physicallyDeleted);
	}

	//--setup/teardown
	@Before public void setup() {
		r = new Record();
		r.physicallyDeleted = false;
		r.logicallyDeleted = false;
		
		env = new RecordEnvironment(){};//default impl
	}
	@After public void teardown() {
		r = null;
		env = null;
	}
}
