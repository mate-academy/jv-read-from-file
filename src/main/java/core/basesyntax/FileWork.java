package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            int value;
            while ((value = reader.read()) != -1) {
                char currentChar = (char) value;

                if (Character.isLetter(currentChar)) {
                    builder.append(currentChar);
                }

                if (Character.isWhitespace(currentChar) && !builder.isEmpty()) {
                    String word = builder.toString().toLowerCase();
                    if (word.charAt(0) == 'w') {
                        result.add(word);
                    }
                    builder.delete(0, builder.length());
                }
            }

            if (!builder.isEmpty()) {
                String word = builder.toString().toLowerCase();
                if (word.charAt(0) == 'w') {
                    result.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
