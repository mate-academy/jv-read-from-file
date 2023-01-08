package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SUBJECT_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error, file not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Error: Cant read file", e);
        }
        String textFromFile = stringBuilder.toString();
        if (textFromFile.isEmpty()) {
            return new String[0];
        }
        stringBuilder = new StringBuilder();
        String[] split = textFromFile.toLowerCase().split("\\W");
        for (String array:split) {
            if (array.startsWith(SUBJECT_LETTER)) {
                stringBuilder.append(array).append(" ");
            }
        }
        String words = stringBuilder.toString();
        if (words.isEmpty()) {
            return new String[0];
        }
        String[] result = words.split(" ");
        Arrays.sort(result);
        return result;
    }
}
