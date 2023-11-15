package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder result = new StringBuilder();
        try {
            String fileText = Files.readString(Path.of(fileName));
            if (fileText.isEmpty()) {
                return new String[0];
            }

            String[] words = fileText.split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                    result.append(word.toLowerCase()).append(" ");
                }
            }
            if (result.isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] sortedArray = result.toString().split(" ");
        Arrays.sort(sortedArray, String.CASE_INSENSITIVE_ORDER);
        return sortedArray;
    }
}
