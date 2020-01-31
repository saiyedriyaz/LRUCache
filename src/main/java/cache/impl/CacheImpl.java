package cache.impl;

import cache.Cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CacheImpl implements Cache {

    private Map<String, CachheValue> internalCache = null;

    private int cacheSize = 0;

    public CacheImpl(int size) {
        internalCache = new HashMap<String, CachheValue>();
        cacheSize = size;
    }

    @Override
    public boolean containsKey(String key) {
        return internalCache.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return internalCache.containsKey(value);
    }

    @Override
    public String get(String key) {
        CachheValue cachheValue = internalCache.get(key);
        if (cachheValue != null) {
            cachheValue.lastUsed = new Date();
            return cachheValue.value;
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        if (internalCache.size() >= cacheSize) {
            CachheValue firstInList = internalCache.values().stream().sorted().findFirst().get();
            internalCache.remove(firstInList.key);
        }
        internalCache.put(key, new CachheValue(key, value, new Date()));
    }

    @Override
    public boolean remove(String key) {
        return internalCache.remove(key) != null;
    }

    @Override
    public int size() {
        return internalCache.size();
    }

    @Override
    public void clear() {
        internalCache.clear();
    }

    class CachheValue implements Comparable<CachheValue> {
        CachheValue(String key, String value, Date lastUsed) {
            this.key = key;
            this.value = value;
            this.lastUsed = lastUsed;
        }

        String key;
        String value;
        Date lastUsed;

        @Override
        public int compareTo(CachheValue o) {
            return this.lastUsed.compareTo(o.lastUsed);
        }
    }
}
