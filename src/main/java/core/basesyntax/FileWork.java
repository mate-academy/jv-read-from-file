package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String stringLine = reader.readLine();
            while (stringLine != null) {
                stringBuilder.append(stringLine).append(System.lineSeparator());
                stringLine = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can not read: ", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String str = stringBuilder.toString();
        return wordsArray(str);
    }

    private String[] wordsArray(String str) {
        String[] strings = str.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith("w") || strings[i].startsWith("W")) {
                stringBuilder.append(strings[i].toLowerCase()).append(" ");
            }
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        strings = stringBuilder.toString().split(" ");
        Arrays.sort(strings);
        return strings;
    }
}







