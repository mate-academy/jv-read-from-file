package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            if (builder == null) {
                return new String[0];
            } else {
                String[] words = builder.toString().replaceAll("[^a-zA-Z ]", "")
                        .toLowerCase().split("\\s+");
                System.out.println(Arrays.toString(words));
                String[] filteredWords = filterWordsStartingWithW(words);
                return filteredWords;
            }
        } catch (FileNotFoundException cat) {
            throw new RuntimeException("Can't read file", cat);
        } catch (IOException cat) {
            throw new RuntimeException("Can't read file", cat);
        }
    }

    public static String[] filterWordsStartingWithW(String[] words) {
        return Arrays.stream(words).filter(word -> word.startsWith("w"))
                .sorted().toArray(String[]::new);
    }
}
