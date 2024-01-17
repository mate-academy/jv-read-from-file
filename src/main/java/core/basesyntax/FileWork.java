package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORDS = "\\W+";
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fileString;
            do {
                fileString = reader.readLine();
                if (fileString != null) {
                    stringBuilder.append(fileString).append(System.lineSeparator());
                }
            } while (fileString != null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        String fileString = stringBuilder.toString().toLowerCase();
        String[] words = fileString.split(WORDS);
        stringBuilder.setLength(0);
        for (String word: words) {
            if (word.charAt(0) == 'w') {
                stringBuilder.append(word).append(SEPARATOR);
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split(SEPARATOR);
        Arrays.sort(result);
        return result;
    }
}
