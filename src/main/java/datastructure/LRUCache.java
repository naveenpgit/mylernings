package datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.System.currentTimeMillis;
import static java.util.Collections.sort;
import static java.util.Comparator.comparing;

//Check LRUCacheTest
@Data
@RequiredArgsConstructor()
public class LRUCache {
	@NonNull
	int capacity;

	private LinkedList<CacheEntry> entries = new LinkedList<>();

	private Map<String, CacheEntry> manifest = new HashMap<>();

	public void add(String key, String value) {
		if (entries.size() == capacity) {
			sort(entries, comparing(CacheEntry::getLastModifiedDate).reversed());
			CacheEntry removed = entries.removeLast();
			manifest.remove(removed.getKey());
		}
		CacheEntry temp = new CacheEntry(key, value, currentTimeMillis());
		entries.add(temp);
		manifest.putIfAbsent(key, temp);
	}

	public String read(String key) {
		AtomicReference<String> v = new AtomicReference<>(null);
		final CacheEntry cacheEntry = manifest.get(key);
		Optional.ofNullable(cacheEntry).ifPresent(e -> {
			e.setLastModifiedDate(currentTimeMillis());
			v.set(e.getValue());
		});
		return v.get();
	}

	@Data
	@AllArgsConstructor
	private class CacheEntry {
		String key;

		String value;

		long lastModifiedDate;

	}
}
