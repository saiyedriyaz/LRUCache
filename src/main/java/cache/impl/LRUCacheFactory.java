package cache.impl;

import cache.Cache;
import cache.CacheFactory;

public class LRUCacheFactory extends CacheFactory {

    @Override
    public Cache newCache(int size) {
        return new CacheImpl(size);
    }
}
