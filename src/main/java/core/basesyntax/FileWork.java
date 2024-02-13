package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        int size = 0;
        int i = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String readFile = builder.toString().toLowerCase();
            String[] splitFile = readFile.split("\\W+");
            if (readFile.isEmpty()) {
                return new String[0];
            }
            for (String word : splitFile) {
                if (splitFile.length > 0 && word.charAt(0) == SPECIFIED_CHARACTER) {
                    size++;
                }
            }
            String[] result = new String[size];
            for (String word : splitFile) {
                if (word.charAt(0) == SPECIFIED_CHARACTER) {
                    result[i] = word;
                    i++;
                }
            }
            Arrays.<String>sort(result, String.CASE_INSENSITIVE_ORDER);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("can't read file");
        }
    }
}
