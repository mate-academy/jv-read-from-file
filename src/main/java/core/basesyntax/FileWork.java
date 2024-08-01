package core.basesyntax;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String WANTED_LETTER = "w";

    public String[] readFromFile(String fileName) {

        List<String> resultList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            StringBuilder builder = new StringBuilder();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }

            String text = builder.toString();
            String[] wordsArray = text.split("\\s+");

            for (String s : wordsArray) {
                String cleanWord = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (cleanWord.startsWith(WANTED_LETTER)) {
                    resultList.add(cleanWord);
                }
            }

            String[] result = resultList.toArray(new String[0]);
            Arrays.sort(result);

            return result;

        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }

}
