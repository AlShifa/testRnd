package com.syne.weakref.cache;

import java.lang.ref.*;
import java.util.*;

public class Cache extends AbstractMap {
	private Map map = new Hashtable();

	public synchronized Set entrySet() {
		Map newMap;
		Iterator iter;
		newMap = new Hashtable();
		// iter = map.entries().iterator();
		iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry me = (Map.Entry) iter.next();
			Reference ref = (Reference) me.getValue();
			Object o = ref.get();
			if (o == null) {
				// Delete cleared reference
				iter.remove();
			} else {
				// Copy out interior object
				newMap.put(me.getKey(), o);
			}
		}

		// Return set of interior objects
		return newMap.entrySet();// .entries();
	}// end entrySet

	public synchronized Object put(Object key, Object value) {
		Reference ref = new WeakReference(value);
		ref = (Reference) map.put(key, ref);
		if (ref != null)
			return (ref.get());
		return null;
	}

}
