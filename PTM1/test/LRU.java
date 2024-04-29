package test;

import java.util.LinkedList;

public class LRU implements CacheReplacementPolicy {
    // Create a linked list of words
    LinkedList<String> words = new LinkedList<String>();

    // Removes and returns the least recently used word from the cache implemented
    // using a linked list
    @Override
    public String remove() {
        if (words.isEmpty()) {
            return null;
        } else {
            return words.poll();
        }
    }

    // Update the words list
    @Override
    public void add(String w) {
        if (w != null) {
            words.remove(w);
            words.add(w);
        }
    }

}