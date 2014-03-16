package cla.enums.patterns.strategy.partial;

/**
 * Pattern "Strategy partial enum implementation"
 * <p>Dans ce pattern, il existe d'autres implémentations, non-enums.
 * Les implémentations enum constants évitent la multiplication de singletons.</p>
 * <p>Ces enums sont typiquement stateless, alors que les implémentations non-enums
 * ne le sont pas forcément (ex. une implémentation avec cache).
 * </p> 
 */
public interface RecordDeletionStrategy {
	
	/**
	 * L'unique méthode, ce qui est le plus fréquent pour une stratégie
	 */
	void deleteRecord(Record r, RecordEnvironment env);
	
	/**
	 * Les "enums dégénérées" sont une sous-variante du pattern,
	 * dans laquelle les enum constants représentent des implémentations non-opérationnelles,
	 * utilisables comme Null Object (Fowler, POEA) ou comme fake object de test.
	 * Quelques exemples de ces fakes objects:
	 */
	public enum DegenerateImpls implements RecordDeletionStrategy {
		
		/**
		 * Null object/dummy. 
		 */
		NOOP {
			@Override public void deleteRecord(Record r, RecordEnvironment env) {
				;
			}
		},

		/**
		 * Implémentation par défaut d'une opération optionnelle (cf. le Collections framework du JDK).
		 */
		UNSUPPORTIVE {
			@Override public void deleteRecord(Record r, RecordEnvironment env) {
				throw new UnsupportedOperationException();
			}
		},
		
		/**
		 * Simule un problème, pour les tests de gestion d'erreur par exemple.
		 */
		DEFECTIVE {
			@Override public void deleteRecord(Record r, RecordEnvironment env) {
				throw new RuntimeException();
			}
		},
		
		;
	}
	
	/**
	 * Les "implémentation connues" sont une autre sous-variante du pattern,
	 * où les enum constants représentent des implémentations opérationnelles fournies par l'API,
	 * mais qui peuvent être complétées par des implémentations de l'application.
	 */
	public enum WellKnownImpls implements RecordDeletionStrategy {
		
		/**
		 * Fait un delete en BD (par ex.)
		 */
		PHYSICAL_DELETION {
			@Override public void deleteRecord(Record r, RecordEnvironment env) {
				env.physicalDeleter().deletePhysically(r);
			}
		},
		
		/**
		 * Met le flag 'DELETED' à true 
		 */
		LOGICAL_DELETION {
			@Override public void deleteRecord(Record r, RecordEnvironment env) {
				env.logicalDeleter().deleteLogically(r);
			}
		},

		;
	}
}
