package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char SPECIFIED_CHARACTER = 'w';
    public static final int FIRST_LATER = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String fileString = bufferedReader.readLine();
            if (fileString == null) {
                return new String[0];
            }
            while (fileString != null) {
                builder.append(fileString)
                        .append(" ");
                fileString = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file ", e);
        }
        String[] strings = builder.toString().replaceAll("[^a-zA-Z ]", "")
                .toLowerCase().split(" ");
        builder = new StringBuilder();
        for (String word: strings) {
            if (word.charAt(FIRST_LATER) == SPECIFIED_CHARACTER) {
                builder.append(word)
                        .append(" ");
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        strings = builder.toString().split(" ");
        Arrays.sort(strings);
        return strings;
    }
}
