package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] filteredWords = new String[0];

        try {
            String content = Files.readString(Paths.get(fileName));
            String[] words = content.split("\\W+");

            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    filteredWords = addWordToArray(filteredWords, word.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }

        Arrays.sort(filteredWords);

        return filteredWords;
    }

    private String[] addWordToArray(String[] array, String word) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = word;
        return newArray;
    }
}
