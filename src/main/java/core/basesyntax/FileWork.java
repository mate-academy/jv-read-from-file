package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String [] words = stringBuilder.toString().split("\\W+");
            int count = 0;
            for (String word: words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    count++;
                }
            }
            String [] result = new String[count];
            count = 0;
            for (String word: words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    result[count] = word;
                    count++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Wrong file name", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t close stream", e);
        }
    }
}
