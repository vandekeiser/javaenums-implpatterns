package cla.enums.patterns.with.values.one;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Un singleton stateful.
 * Ce pattern est parfois découragé dans la littérature mais sans trop dire pourquoi?
 * Effective Java encourage l'implémentation des enums par singleton, mais sans mentionner la distinction stateless/stateful.
 * @author CLA  
 */
public enum Repository {
	
	instance;

	private final ConcurrentMap<String, Object> repo = new ConcurrentHashMap<>();
	
	public Object forKey(String key) {
		Object obj = new Object();
		repo.put(key, obj);
		return obj;
	}
	
}
