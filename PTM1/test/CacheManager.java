package test;

import java.util.HashSet;

public class CacheManager {

    HashSet<String> cache = new HashSet<>();
    int size;
    CacheReplacementPolicy crp;

    // Constructor
    public CacheManager(int size, CacheReplacementPolicy crp) {
        this.size = size;
        this.crp = crp;
    }

    // Adds a certain word to the cache
    public void add(String word) {
        crp.add(word);
        cache.add(word);
        
        if (cache.size() > size) {
            cache.remove(crp.remove());
        }
    }

    // Checks if a certain word is on the cache
    public boolean query(String w) {
        return cache.contains(w);
    }
}