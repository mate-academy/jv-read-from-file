package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine()).append(" ");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            return new String[0];
        }

        String[] words = builder.toString()
                .toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .split("\\s+");

        return Arrays.stream(words)
                .filter(word -> word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
