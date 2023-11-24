package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final Pattern NON_ALPHABETIC_PATTERN = Pattern.compile("[^A-Za-z]+");

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }

            String fileContent = stringBuilder.toString();
            if (fileContent.isEmpty()) {
                return new String[0]; // Return empty array for empty file
            }

            String[] words = fileContent.split(" ");
            StringBuilder filteredWords = new StringBuilder();

            for (String word : words) {
                if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    String cleanedWord = word.replaceAll(NON_ALPHABETIC_PATTERN.pattern(), "")
                            .toLowerCase();
                    filteredWords.append(cleanedWord).append(",");
                }
            }

            String filteredContent = filteredWords.toString();
            if (filteredContent.isEmpty()) {
                return new String[0]; // Return empty array if no words start with 'w'
            }

            String[] result = filteredContent.split(",");
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
