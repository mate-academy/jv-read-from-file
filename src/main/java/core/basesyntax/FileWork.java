package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(" ");
                for (String word : split) {
                    String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (cleanWord.startsWith("w")) {
                        stringBuilder.append(cleanWord).append(" ");
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        } else {
            String[] splitBuilder = stringBuilder.toString().split(" ");
            return splitBuilder;
        }
    }
}
