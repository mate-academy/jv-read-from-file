package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private static final String PUNCTUAT_REGEX = "[!\\\"#$%&'()*+,-./:;<=>?@[\\\\\\\\]^_`{|}~]";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            List<String> filteredWords = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleaneWords = word.replaceAll(PUNCTUAT_REGEX, "").toLowerCase();
                    if (cleaneWords.startsWith("w")) {
                        filteredWords.add(cleaneWords);
                    }
                }
            }
            String[] result = filteredWords.toArray(new String[0]);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Something is wrong");
        }
    }
}
