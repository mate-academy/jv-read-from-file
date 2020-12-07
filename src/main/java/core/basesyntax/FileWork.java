package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringWords = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] textString = stringBuilder.toString().replaceAll("\\W", " ").split(" ");
            for (String string : textString) {
                if (string.toLowerCase().startsWith(LETTER)) {
                    stringWords.append(string.toLowerCase()).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringWords.length() == 0) {
            return new String[0];
        }
        String[] finishWords = stringWords.toString().trim().split(" ");
        Arrays.sort(finishWords);
        return finishWords;
    }
}
