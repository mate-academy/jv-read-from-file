package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = stringBuilder.toString().split("\\W+");
        stringBuilder.setLength(0);
        for (String word : words) {
            if (word.startsWith(FIRST_LETTER)) {
                stringBuilder.append(word).append(" ");
            }
        }
        String[] sortedResultArray = stringBuilder.toString().split(" ");
        Arrays.sort(sortedResultArray);
        return stringBuilder.toString().length() == 0 ? new String[]{} : sortedResultArray;
    }
}
