package datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.System.currentTimeMillis;
import static java.util.Collections.sort;
import static java.util.Comparator.comparing;
import static java.util.Optional.ofNullable;

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
		entries.addLast(temp);
		manifest.putIfAbsent(key, temp);
	}

	public String read(String key) {
		return ofNullable(manifest.get(key)).map(cacheEntry -> {
			cacheEntry.setLastModifiedDate(currentTimeMillis());
			return cacheEntry.getValue();
		}).orElse(null);
	}

	@Data
	private class CacheEntry {
		public CacheEntry(String key, String value, long lastModifiedDate) {
			this.key = key;
			this.value = value;
			this.lastModifiedDate = lastModifiedDate;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public long getLastModifiedDate() {
			return lastModifiedDate;
		}

		public void setLastModifiedDate(long lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
		}

		String key;

		String value;

		long lastModifiedDate;

	}

	public static void main(String[] args) {

	}
}
