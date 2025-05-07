package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().charAt(0) == SPECIFIED_CHAR) {
                        stringList.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file" + e);
        }
        String[] result = stringList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
