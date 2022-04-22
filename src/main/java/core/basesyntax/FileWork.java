package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String stringFromFile;
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't read", e);
        }
        stringFromFile = stringBuilder.toString().toLowerCase();
        String[] wordArray = stringFromFile.split("\\W+");
        Arrays.sort(wordArray);
        stringBuilder.delete(0, stringBuilder.length());
        for (String word : wordArray) {
            if (word.charAt(0) == 'w') {
                stringBuilder.append(word).append(" ");
            }
        }
        String[] result = stringBuilder.toString().split(" ");
        if (result[0].equals("")) {
            return new String[0];
        } else {
            return result;
        }
    }
}
