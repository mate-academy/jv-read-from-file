package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final char SPECIFIED_CHARACTER_UPPERCASE = 'W';

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String data = reader.readLine();
            while (data != null) {
                builder.append(data).append(System.lineSeparator());
                data = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File can`t be found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (builder.length() == 0) {
            return new String[] {};
        }
        StringBuilder builderResult = new StringBuilder();
        String[] textFromFile = builder.toString().split("\\W+");

        for (String word : textFromFile) {
            if (word.charAt(0) == SPECIFIED_CHARACTER
                    ||
                    word.charAt(0) == SPECIFIED_CHARACTER_UPPERCASE) {
                builderResult.append(word.toLowerCase()).append(" ");
            }
        }
        if (builderResult.length() == 0) {
            return new String[] {};
        }
        String[] result = builderResult.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
