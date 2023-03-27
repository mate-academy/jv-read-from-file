package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line.toLowerCase()).append(" ");
            }
            reader.close();
            String[] words = sb.toString().split("[\\p{Punct}\\s]+");
            return Arrays.stream(words)
                .filter(word -> word.startsWith("w"))
                .map(word -> word.replaceAll("\\p{Punct}", ""))
                .sorted()
                .toArray(String[]::new);
        } catch (Exception e) {
            return new String[0];
        }
    }
}
