package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_WORD_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cant find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] strings = builder.toString().toLowerCase().split("\\W+");
        builder = new StringBuilder();
        for (String string : strings) {
            if (string.charAt(0) == FIRST_WORD_LETTER) {
                builder.append(string).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
