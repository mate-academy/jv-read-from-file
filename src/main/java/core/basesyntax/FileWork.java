package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String fileData;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            fileData = builder.toString().toLowerCase();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] words = fileData.split("\\W+");
        builder.setLength(0);

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(SPECIFIED_CHARACTER)) {
                builder.append(words[i]).append(" ");
            }
        }

        String result = builder.toString();
        String[] resultArray;
        if (result.length() == 0) {
            resultArray = new String[0];
        } else {
            resultArray = result.split(" ");
            Arrays.sort(resultArray);
        }

        return resultArray;
    }
}
