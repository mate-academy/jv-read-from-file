package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final int FIRST_ELEMENT = 0;
    private static final char TARGET_LETTER = 'w';
    private static final String NON_LETTER_REGEX = "[^\\p{L}]+";

    public String[] readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return new String[0]; // Return an empty array if the file does not exist or is empty
        }

        List<String> correctWords = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(NON_LETTER_REGEX);
                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase()
                            .charAt(FIRST_ELEMENT) == TARGET_LETTER) {
                        correctWords.add(word.toLowerCase());
                    }
                }
            }
        }

        List<String> modifiedWords = new ArrayList<>();
        for (String word : correctWords) {
            if (word.length() > 1) {
                modifiedWords.add(word.substring(1));
            } else {
                modifiedWords.add("");
            }
        }

        Collections.sort(modifiedWords);

        String[] resultArray = new String[correctWords.size()];
        for (int i = 0; i < modifiedWords.size(); i++) {
            resultArray[i] = TARGET_LETTER + modifiedWords.get(i);
        }

        return resultArray;
    }
}
