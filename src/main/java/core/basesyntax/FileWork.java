package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return new String[0];
        }
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.toLowerCase().split("\\W+");
                for (String token : tokens) {
                    if (!token.isEmpty() && token.charAt(0) == SPECIFIED_LETTER) {
                        result.add(token);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(result);

        return result.toArray(new String[0]);
    }
}

