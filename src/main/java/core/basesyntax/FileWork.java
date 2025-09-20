package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String content = stringBuilder.toString().toLowerCase();
        String[] words = content.split("\\W+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.startsWith("w") && !word.isEmpty()) {
                result.add(word);
            }
        }

        String[] array = result.toArray(new String[0]);
        Arrays.sort(array);
        return array;
    }
}
