package test;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class LFU implements CacheReplacementPolicy {

    HashMap<String, Integer> timesCalled = new HashMap<>(); // Count the number of times a word is being used
    PriorityQueue<String> q = new PriorityQueue<>(Comparator.comparingInt(this::applyAsInt)); // Priortize the words by
                                                                                              // the amount of use

    // Update the count of a string and set the priority of it in the queue
    @Override
    public void add(String word) {
        timesCalled.put(word, timesCalled.getOrDefault(word, 0) + 1);
        if (!q.isEmpty())
            q.remove(word); // Remove the string (if needed) from the queue and re-add it to update its
                            // position
        q.add(word);
    }

    // Get the count for a string
    public int getCount(String s, HashMap<String, Integer> timesCalled) {
        return timesCalled.getOrDefault(s, 0);
    }

    // Return count for a string
    private int applyAsInt(String s) {
        return getCount(s, timesCalled);
    }

    // Returns the least used word
    @Override
    public String remove() {
        if (q.isEmpty())
            return null;
        else {
            String w = q.poll();
            timesCalled.remove(w);
            return w;
        }
    }
};