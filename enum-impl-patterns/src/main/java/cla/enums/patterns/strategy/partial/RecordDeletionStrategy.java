package cla.enums.patterns.strategy.partial;

/**
 * Pattern "Strategy partial enum implementation"
 * <p>Dans ce pattern, il existe d'autres implémentations, non-enums.
 * Les implémentations enum constants évitent la multiplication de singletons.</p>
 * <p>Ces enums sont typiquement stateless, alors que les implémentations non-enums
 * ne le sont pas forcément (ex. une implémentation cachante).
 * </p> 
 */
public interface RecordDeletionStrategy {
	
	void deleteRecord(Record r, RecordEnv env);
	
	/**
	 * Les enums dégénérées sont une variante du pattern,
	 * dans laquelle les enum constants représentent des implémentations non-opérationnelles,
	 * utilisables comme Null Object (Fowler, POEA) ou comme fake object de test.
	 */
	public enum DegenerateImpls implements RecordDeletionStrategy {
		
		/**
		 * Null object/dummy. 
		 */
		NOOP {
			@Override public void deleteRecord(Record r, RecordEnv env) {
				;
			}
		},

		/**
		 * For optional operations.
		 */
		UNSUPPORTIVE {
			@Override public void deleteRecord(Record r, RecordEnv env) {
				throw new UnsupportedOperationException();
			}
		},
		
		/**
		 * Simulates failure.
		 */
		DEFECTIVE {
			@Override public void deleteRecord(Record r, RecordEnv env) {
				throw new RuntimeException();
			}
		},
		
		/**
		 * Enables testing the executing thread's daemon status 
		 * by not permitting exit otherwise. 
		 */
		SLEEPING_DEEPLY {
			@Override public void deleteRecord(Record r, RecordEnv env) {
				while(true)
				try {
					Thread.sleep(Long.MAX_VALUE);
				} catch (InterruptedException e) {
					//Ignore royally
				}
			}
		},
		
		;
	}
	
	/**
	 * Les implémentation connues sont une variante du pattern,
	 * où les enum constants représentent des implémentations opérationnelles fournies par l'API,
	 * qui peuvent être complétées par des implémentations custom.
	 */
	public enum WellKnownImpls implements RecordDeletionStrategy {
		
		/**
		 */
		PHYSICAL_DELETION {
			@Override public void deleteRecord(Record r, RecordEnv env) {
				env.physicalDeleter().deletePhysically(r);
			}
		},
		
		/**
		 */
		LOGICAL_DELETION {
			@Override public void deleteRecord(Record r, RecordEnv env) {
				env.logicalDeleter().deleteLogically(r);
			}
		},

		;
	}
}
