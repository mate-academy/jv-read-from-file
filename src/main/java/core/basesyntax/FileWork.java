package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.toLowerCase().startsWith("w")) {
                    stringBuilder.append(word.toLowerCase()).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String str = stringBuilder.toString().replaceAll("[^a-zA-Z ]", "");
        if (str.isEmpty()) {
            return new String[0];
        }
        String[] arrayResult = str.split(" ");
        Arrays.sort(arrayResult);
        return arrayResult;
    }
}
