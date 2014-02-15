package cla.enums.patterns.strategy.partial;

/**
 * Abstraction de l'environnement dont dépend RecordDeletionStrategy.
 * Cette classe fait partie du même package, alors que l'implémentation réside dans le package <tt>se</tt>
 * */
public interface RecordEnvironment {

	public interface PhysicalDeleter {
		void deletePhysically(Record r);
	}	
	public interface LogicalDeleter {
		void deleteLogically(Record r);
	}
	
	default PhysicalDeleter physicalDeleter() {
		return (Record r) -> r.physicallyDeleted=true;
	}
	default LogicalDeleter logicalDeleter() {
		return (Record r) -> r.logicallyDeleted=true;
	}
	
}
