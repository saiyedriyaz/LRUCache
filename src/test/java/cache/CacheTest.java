package cache;

import cache.impl.LRUCacheFactory;
import org.junit.Assert;
import org.junit.Test;

public class CacheTest {

    private Cache cache = new LRUCacheFactory().newCache(3);

    @Test
    public void addTest() {
        cache.put("mango", "yellow");
        cache.put("cherry", "red");
        cache.put("lemon", "green");
        Assert.assertEquals(cache.size(), 3);
    }

    @Test
    public void putTest1() throws Exception {
        cache.put("mango", "yellow");
        Thread.sleep(1000);
        cache.put("cherry", "red");
        cache.put("lemon", "green");
        cache.put("orange", "orange");

        Assert.assertNull(cache.get("mango"));
    }

    @Test
    public void putTest2() throws Exception {
        cache.put("mango", "yellow");
        Thread.sleep(1000);

        cache.put("cherry", "red");
        Thread.sleep(1000);

        cache.put("lemon", "green");
        cache.get("mango");
        cache.put("orange", "orange");

        Assert.assertNull(cache.get("cherry"));
    }
}
