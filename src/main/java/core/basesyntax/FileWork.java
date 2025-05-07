package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String text = stringBuilder.toString();
        String[] wordsArray = text.split("\\W+");
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (String word : wordsArray) {
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                builder.append(word)
                        .append(" ");
                count++;
            }
        }
        if (count == 0) {
            return new String[]{};
        }
        String[] array = builder.toString().toLowerCase().split(" ");
        Arrays.sort(array);
        return array;
    }
}

