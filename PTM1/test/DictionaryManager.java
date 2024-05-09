package test;
import java.util.HashMap;

public class DictionaryManager {
    HashMap<String, Dictionary> dictionaryMap = new HashMap<>();
    private static DictionaryManager instance = null;

    // Singelton
    public static DictionaryManager get() {
        if (instance == null) {
            instance = new DictionaryManager();
        }
        return instance;
    }

    // Activate query
    public boolean query(String... books) {
        boolean result = false;
        String w = books[books.length - 1];
        for (int i = 0; i < books.length - 1; i++) {
            if (!dictionaryMap.containsKey(books[i])) {
                dictionaryMap.put(books[i], new Dictionary(books[i]));
            }
            if (dictionaryMap.get(books[i]).query(w)) {
                result = true;
            }
        }
        return result;
    }

    // Get the size of the dictionary map
    int getSize() {
        return dictionaryMap.size();
    }

    public boolean challenge(String... books) {
        boolean result = false;
        String w = books[books.length - 1];
        for (int i = 0; i < books.length - 1; i++) {
            if (!dictionaryMap.containsKey(books[i])) {
                dictionaryMap.put(books[i], new Dictionary(books[i]));
            }
            if (dictionaryMap.get(books[i]).challenge(w)) {
                result = true;
            }
        }
        return result;
    }
}