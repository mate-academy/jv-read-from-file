package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String temporaryString;
        String[] result = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            temporaryString = bufferedReader.readLine();
            while (temporaryString != null) {
                stringBuilder.append(temporaryString);
                stringBuilder.append(" ");
                temporaryString = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        temporaryString = stringBuilder.toString().toLowerCase();
        String[] array = temporaryString.split("\\W+");
        stringBuilder.setLength(0);

        for (String word : array) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
        }

        temporaryString = stringBuilder.toString();
        if (temporaryString.length() > 0) {
            result = temporaryString.split(" ");
            Arrays.sort(result);
        }
        return result;
    }
}

