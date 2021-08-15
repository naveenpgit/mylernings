package datastructure;

import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LRUCacheTest {

	@Test
	public void testLRUCache() throws InterruptedException {
		LRUCache lruCache = new LRUCache(3);

		lruCache.add("1", "one");
		sleep(100);
		lruCache.add("2", "two");
		sleep(100);
		lruCache.add("3", "three");
		sleep(100);
		assertEquals("one", lruCache.read("1"));
		lruCache.add("4", "four");
		assertNull(lruCache.read("2"));
	}
}