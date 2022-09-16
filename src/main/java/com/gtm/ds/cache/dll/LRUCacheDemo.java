package com.gtm.ds.cache.dll;

import com.gtm.ds.cache.dll.impl.LRUCache;

public class LRUCacheDemo {

	public static void main(String[] args) {
		Cache<Integer, String> cache = new LRUCache<>(3);

		cache.put(1, "one");
		cache.put(2, "two");
		cache.put(3, "Three");
		System.out.println(cache.get(2));
		cache.put(1, "one");
		cache.put(4, "Four");
		cache.put(5, "Five");
		cache.display();
	}

}
