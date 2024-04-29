package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Dictionary {

    BloomFilter bloomFilterr;
    String[] files;
    CacheManager existingWords;
    CacheManager fakeWords;

    // Constructor
    public Dictionary(String... file) {

        this.files = new String[file.length];
        System.arraycopy(file, 0, this.files, 0, file.length);
        this.fakeWords = new CacheManager(100, new LFU());
        this.existingWords = new CacheManager(400, new LRU());
        this.bloomFilterr = new BloomFilter(256, "MD5", "SHA1");
        try {
            for (String f : files) {
                BufferedReader r = new BufferedReader(new FileReader(f));
                String line = r.readLine();
                String[] words;
                words = line.split(" ");
                {
                    for (String word : words)
                        bloomFilterr.add(word);
                }
                r.close();
            }
        } catch (Exception error) {
            System.out.println("Habing troubles reading the dictionary file" + error);
        }
    }

    // Method to activate the IO searcher and update the CacheManagers accordingly
    Boolean challenge(String word) {
        try {
            if (IOSearcher.search(word, files)) {
                existingWords.add(word);
                return true;
            } else {
                fakeWords.add(word);
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }

    // Determine the validity of a given word and update the CacheManagers
    // accordingly
    Boolean query(String w) {
        if (existingWords.query(w))
            return true;
        else if (fakeWords.query(w))
            return false;
        else if (bloomFilterr.contains(w)) {
            existingWords.add(w);
            return true;
        } else {
            fakeWords.add(w);
            return false;
        }
    }
}