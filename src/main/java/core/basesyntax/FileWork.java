package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String regex = "\\p{Punct}+";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line).append(" ");
            }

            String[] words = pattern.matcher(sb.toString().toLowerCase()).replaceAll("").split("\\s+");
            String[] filteredWords = Arrays.stream(words)
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);

            return filteredWords;
        } catch (IOException e) {
            return new String[0];
        }
    }
}