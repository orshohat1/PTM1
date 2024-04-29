package test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.math.BigInteger;

public class BloomFilter {

    private final BitSet bitset;
    int size;
    MessageDigest md;
    List<MessageDigest> digestList = new ArrayList<>();

    // Constructor
    public BloomFilter(int size, String... hashFunctions) {
        this.bitset = new BitSet();
        this.size = size;
        for (int i = 0; i < hashFunctions.length; i++) {
            try {
                // Create a new MessageDigest instance
                this.md = MessageDigest.getInstance(hashFunctions[i]);
            } catch (NoSuchAlgorithmException error) {
                throw new RuntimeException("Error: [" + error + "]" + "[" + i + "]");
            }
            this.digestList.add(md);
        }
    }

    // Checks if a given string w is likely to be present in a BloomFilter based on
    // its digest value
    boolean contains(String w) {
        for (MessageDigest md : digestList) {
            byte[] h = md.digest(w.getBytes());
            BigInteger bi = new BigInteger(1, h);
            int i = Math.abs(bi.abs().intValue()) % size;
            if (!bitset.get(i))
                return false;
        }
        return true;
    }

    // Add a word to the BloomFilter
    void add(String w) {
        for (MessageDigest md : digestList) {
            byte[] h = md.digest(w.getBytes());
            BigInteger bi = new BigInteger(1, h);
            int i = Math.abs(bi.abs().intValue()) % size;
            bitset.set(i, true);
        }
    }

    // Overrides the default toString() method inherited from Object Class
    // Return a string representation of the bit array,
    // with each set bit represented by '1' and each unset bit represented by '0'
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bitset.length(); i++)
            builder.append(bitset.get(i) ? "1" : "0");
        return builder.toString();
    }
}