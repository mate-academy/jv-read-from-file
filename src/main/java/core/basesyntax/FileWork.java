package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        int count = 0;

        try {
            String fileContent = Files.readString(Path.of(fileName));
            if (fileContent.isEmpty()) {
                return new String[0];
            }
            String[] arrayFromFile = fileContent.split("\\W+");
            for (String word : arrayFromFile) {
                if (word.charAt(0) == 'W' || word.charAt(0) == 'w') {
                    count++;
                }
            }

            String[] arrayWithWords = new String[count];
            int index = 0;

            for (String word : arrayFromFile) {
                if (!word.isEmpty() && (word.charAt(0) == 'W' || word.charAt(0) == 'w')) {
                    arrayWithWords[index++] = word;
                }
            }

            for (int i = 0; i < arrayWithWords.length; i++) {
                arrayWithWords[i] = arrayWithWords[i].toLowerCase();
            }

            Arrays.sort(arrayWithWords);
            return arrayWithWords;

        } catch (IOException e) {
            throw new RuntimeException("Can`t read this file", e);
        }
    }
}
