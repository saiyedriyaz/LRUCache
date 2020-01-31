package cache;

/**
 * Implementation of this interface provide a LRU (least recently used) cache.
 *
 * <ul>
 * <li>The size of the cache needs to be specified (see {@link CacheFactory}</li>
 * <li>It needs to support running in a multithreading environment.</li>
 * </ul>
 */
public interface Cache {

	boolean containsKey(String key);

	boolean containsValue(String value);

	String get(String key);

	void put(String key, String value);

	/** @return <code>true</code> if the cache contained the specified element */
	boolean remove(String key);

	int size();

	void clear();
}
