package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            String dataAfterReading = builder.toString();
            char filter = 'w';
            String[] split = dataAfterReading.split("[\\s\\p{Punct}]+");
            ArrayList<String> temp = new ArrayList<>();
            for (String words : split) {
                String cleaned = (words.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "")
                        .toLowerCase());
                if (cleaned.startsWith(String.valueOf(filter))) {
                    temp.add(words.toLowerCase());
                }
            }
            Collections.sort(temp);
            return temp.toArray(new String[0]);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
