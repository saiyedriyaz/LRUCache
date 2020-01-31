package cache;

public abstract class CacheFactory {
	/** Implementations of this class create caches of for given value class and size. */
	public abstract Cache newCache(int size);
}
