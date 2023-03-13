package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            StringBuilder stringWithWords = new StringBuilder();
            String string = new String(Files.readAllBytes(file.toPath()));
            String[] array = string.replaceAll("[^a-zA-Z ]", "")
                    .replaceAll("\n", " ")
                    .toLowerCase().split(" ");
            for (String word : array) {
                if (word.startsWith("w")) {
                    stringWithWords.append(word).append(" ");
                }
            }
            String[] resultArray = stringWithWords.toString().split(" ");
            Arrays.sort(resultArray);
            if (resultArray[0].equals("")) {
                return new String[0];
            }
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
