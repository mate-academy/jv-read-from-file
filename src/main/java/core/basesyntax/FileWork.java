package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String letter = "w";

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
            for (int i = 0; i < textString.length; i++) {
                if (textString[i].toLowerCase().startsWith(letter)) {
                    stringWords.append(textString[i].toLowerCase()).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringWords.length() == 0) {
            String [] resultWords = new String[0];
            return resultWords;
        }
        String [] finishWords = stringWords.toString().trim().split(" ");
        Arrays.sort(finishWords);
        return finishWords;
    }
}
