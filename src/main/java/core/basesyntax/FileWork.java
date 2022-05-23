package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        FileReader fileReader;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file" + e);
        }

        BufferedReader reader = new BufferedReader(fileReader);
        StringBuilder builder = new StringBuilder();
        StringBuilder build = new StringBuilder();
        String[] arrayWithWords;
        String startsWithW = "w";

        try (reader) {
            String textFromFile = reader.readLine();
            while (textFromFile != null) {
                builder.append(" ").append(textFromFile).append(System.lineSeparator());
                textFromFile = reader.readLine();
            }
            arrayWithWords = builder.toString().split(" ");
            for (int i = 0; i < arrayWithWords.length; i++) {
                if (arrayWithWords[i].toLowerCase().startsWith(startsWithW)) {
                    arrayWithWords[i] = arrayWithWords[i].replaceAll("[^\\w]",
                            "");
                    build.append(arrayWithWords[i]).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }

        if (build.toString().isEmpty()) {
            return new String[0];
        }

        arrayWithWords = build.toString().toLowerCase().split(" ");
        Arrays.sort(arrayWithWords);
        return arrayWithWords;
    }
}
