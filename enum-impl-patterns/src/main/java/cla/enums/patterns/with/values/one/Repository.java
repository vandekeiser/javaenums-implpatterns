package cla.enums.patterns.with.values.one;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Un singleton stateful.
 * Ce pattern est parfois découragé dans la littérature mais sans trop dire pourquoi?
 * Effective Java et Java puzzlers encouragent l'implémentation du singleton par enum, 
 * mais sans mentionner la distinction stateless/stateful.
 */
public enum Repository {
	
	instance;

	private final ConcurrentMap<String, Object> repo = new ConcurrentHashMap<>();
	
	public Object forKey(String key) {
		Object obj = new Object();
		repo.putIfAbsent(key, obj);
		return obj;
	}
	
}
