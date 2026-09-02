package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPLIT_REGEX = "\\W+";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String fileText = convertFileTextToString(fileName).toLowerCase();
        String[] words = fileText.split(SPLIT_REGEX);
        int filteredWordsLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].startsWith(SPECIFIED_CHARACTER)) {
                words[i] = "";
            } else {
                filteredWordsLength++;
            }
        }

        String[] filteredWords = new String[filteredWordsLength];
        int currentFilteredWordsIndex = 0;
        for (String word : words) {
            if (word.length() != 0) {
                filteredWords[currentFilteredWordsIndex++] = word;
            }
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }

    public String convertFileTextToString(String fileName) {
        File file = new File(fileName);
        StringBuilder fileText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                fileText.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return fileText.toString();
    }
}
