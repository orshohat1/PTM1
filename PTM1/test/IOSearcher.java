package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOSearcher {

    // Search for a specific word within one or more text files
    static boolean search(String word, String... file) throws IOException {
        List<String> files = new ArrayList<>();
        Collections.addAll(files, file);

        for (String f : files) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                if (line.contains(word)) {
                    br.close();
                    return true;
                }
                line = br.readLine();
            }
            br.close();
        }
        return false;
    }
}