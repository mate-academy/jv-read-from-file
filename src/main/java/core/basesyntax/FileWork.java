package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int LETTER_INDEX = 0;
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file!", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] fileSplit = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String s : fileSplit) {
            if (s.charAt(LETTER_INDEX) == SPECIFIED_CHARACTER) {
                builder.append(s).append(",");
            }
        }
        if (builder.isEmpty()) {
            return new String[0];
        }
        String[] result = builder.toString().substring(0, builder.length() - 1).split(",");
        Arrays.sort(result);
        return result;
    }
}
