package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String text;
        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            return new String[0];
        }
        text = text.toLowerCase();
        text = text.replaceAll("[,.?!]", " ");
        String[] words = text.split("[ \n]");
        int counter = 0;
        for (String word : words) {
            if (!word.isEmpty() && word.startsWith("w")) {
                counter++;
            }
        }
        if (counter == 0) {
            return new String[0];
        }
        String[] result = new String[counter];
        int index = 0;
        for (String word : words) {
            if (!word.isEmpty() && word.startsWith("w")) {
                result[index++] = word;
            }
        }
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if (result[j].compareTo(result[j + 1]) > 0) {
                    String temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }
}
