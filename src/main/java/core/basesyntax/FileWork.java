package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String TARGET_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder result = new StringBuilder();
        StringBuilder wordsFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                wordsFromFile.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IndexOutOfBoundsException | IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] withoutPunctuation = wordsFromFile.toString().toLowerCase().split("\\W+");
        Arrays.sort(withoutPunctuation);
        for (String s : withoutPunctuation) {
            if (s.startsWith(TARGET_CHAR)) {
                result.append(s).append(" ");
            }
        }

        if (result.toString().isEmpty()) {
            return new String[] {};
        }

        return result.toString().split(" ");
    }
}
