package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            }

            String[] words = stringBuilder.toString().split("\\W+");
            StringBuilder filteredWords = new StringBuilder();
            boolean found = false;
            for (String word : words) {
                if (Pattern.matches("[wW]\\w*", word)) {
                    filteredWords.append(word.toLowerCase()).append(" ");
                    found = true;
                }
            }
            if (!found) {
                return new String[0];
            }
            String[] result = filteredWords.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
