package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try (FileReader fileReader = new FileReader(fileName)) {
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                String value = reader.readLine();
                StringBuilder builder = new StringBuilder();
                while (value != null) {
                    builder.append(value).append(System.lineSeparator());
                    value = reader.readLine();
                }
                String text = builder.toString();
                String[] words = text.toLowerCase().split("[^a-z]+");
                List<String> result = new ArrayList<>();
                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith("w")) {
                        result.add(word);
                    }
                }
                Collections.sort(result);
                String[] array = result.toArray(new String[0]);
                return array;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
