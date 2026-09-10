package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = new File(fileName).toPath();
        int counter = 0;
        String[] result;

        try {
            String[] linesList = Files.readAllLines(path).toArray(new String[0]);
            StringBuilder sb = new StringBuilder();

            for (String line : linesList) {
                sb.append(line).append(" ");
            }

            String[] noPunctuationArray = sb.toString().split("\\W+");

            for (String word : noPunctuationArray) {
                if (word.startsWith("w") || word.startsWith("W")) {
                    counter++;
                }
            }

            result = new String[counter];
            counter = 0;

            for (String word : noPunctuationArray) {
                if (word.startsWith("w") || word.startsWith("W")) {
                    result[counter] = word.toLowerCase();
                    counter++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file!" + e);
        }

        Arrays.sort(result,null);

        return result;
    }
}
