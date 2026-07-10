package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final int COUNTER = 0;
    private static final int INDEX = 0;

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder lines = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.append(line).append(" ");
                line = bufferedReader.readLine();
            }
            String content = lines.toString();
            String[] words = content.split("\\s+|[^a-zA-Z\\w]+");
            int count = COUNTER;
            for (String word: words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    count++;
                }
            }
            String[] result = new String[count];
            int index = INDEX;
            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    result[index++] = word.toLowerCase();
                }
            }
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found" + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
