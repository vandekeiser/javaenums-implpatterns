package cla.enums.patterns.strategy.partial;

public interface RecordEnv {

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
