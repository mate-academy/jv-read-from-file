package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = {};
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);

        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String[] array = strings.toArray(new String[0]);

            for (String line: array) {
                String cleanLine = line
                        .replace("?", "")
                        .replace(".", "")
                        .replace("!", "")
                        .replace("-", "")
                        .replace(",", "");

                String[] lineArray = cleanLine.split(" ");

                for (String word: lineArray) {
                    String lowerWord = word.toLowerCase();

                    if (lowerWord.charAt(0) == 'w') {
                        stringBuilder
                                .append(lowerWord)
                                .append(" ");
                    }
                }

                result = stringBuilder.isEmpty()
                        ? new String[0]
                        : stringBuilder.toString().split(" ");

                Arrays.sort(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return result;
    }
}
