package cla.enums.patterns.strategy.partial;

import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.DEFECTIVE;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.NOOP;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.SLEEPING_DEEPLY;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.DegenerateImpls.UNSUPPORTIVE;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.WellKnownImpls.LOGICAL_DELETION;
import static cla.enums.patterns.strategy.partial.RecordDeletionStrategy.WellKnownImpls.PHYSICAL_DELETION;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecordDeletionStrategyTest {

	private Record r;
	private RecordEnvironment env;
	
	//Degenerate impls
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
	
	@Test public void sleepingDeeply() throws InterruptedException {
		Runnable uninterruptibleSleep = ()->SLEEPING_DEEPLY.deleteRecord(r, env);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		Future<?> taskComplete = exec.submit(uninterruptibleSleep);
		
		exec.shutdownNow();
		exec.awaitTermination(1, TimeUnit.SECONDS);
		assertFalse(taskComplete.isDone());
	}
	
	//Well known, operational impls
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
