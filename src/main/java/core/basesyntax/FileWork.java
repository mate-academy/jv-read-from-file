package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char START_CHARACTER = 'w';
    private static final String DELETING_REGEX = "[!\\.,?]";

    public String[] readFromFile(String fileName) {
        StringBuilder dataFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String test = reader.readLine();
            while (test != null) {
                dataFromFile.append(test).append(" ");
                test = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return justDoubleVeeWords(dataFromFile.toString());
    }

    public String[] justDoubleVeeWords(String text) {
        if (text.isEmpty()) {
            return new String[]{};
        }

        String[] testArray = text.toLowerCase().replaceAll(DELETING_REGEX, "").split(" ");
        StringBuilder searchingWords = new StringBuilder();
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i].charAt(0) == START_CHARACTER) {
                searchingWords.append(testArray[i]).append(" ");
            }
        }
        String postSearching = searchingWords.toString().trim();
        if (postSearching.isEmpty()) {
            return new String[]{};
        }
        String[] preReturn = postSearching.split(" ");
        Arrays.sort(preReturn);
        return preReturn;
    }
}
