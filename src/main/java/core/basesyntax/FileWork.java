package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String data = getStringFromFile(fileName);
        String[] result = getWordsOnCharW(data);
        Arrays.sort(result);
        return result.length == 1 ? new String[0] : result;
    }

    private String[] getWordsOnCharW(String data) {
        String[] words = data.toLowerCase().split("\\W+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() != 0 && word.charAt(0) == 'w') {
                result.append(word).append(' ');
            }
        }
        return result.toString().split(" ");
    }

    private String getStringFromFile(String fileName) {
        String data;
        try {
            data = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        return data;
    }
}
