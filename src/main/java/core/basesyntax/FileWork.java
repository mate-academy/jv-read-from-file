package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    private static final String UNUSED_CHARACTERS = "[\\.,?!]";

    public String[] readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Can't close resource", e);
            }
        }

        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }

        String[] arrayOfAllWords = stringBuilder.toString().toLowerCase()
                .replaceAll(UNUSED_CHARACTERS, "").trim().split("\\s+");
        Arrays.sort(arrayOfAllWords);
        stringBuilder = new StringBuilder();

        for (String singleWord : arrayOfAllWords) {
            if (singleWord.charAt(0) == SPECIFIED_CHARACTER) {
                stringBuilder.append(singleWord).append(" ");
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        return stringBuilder.toString().split(" ");
    }
}
