package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilders = new StringBuilder();
        String value;
        int count = 0;
        int index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((value = reader.readLine()) != null) {
                stringBuilders.append(value).append(" ");
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read a file: ", e);
        }

        String[] words = stringBuilders.toString().toLowerCase().split("\\W+");

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                continue;
            }

            if (words[i].startsWith("w")) {
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }

        String[] result = new String[count];

        for (String word : words) {

            if (word.toLowerCase().startsWith("w")) {
                result[index++] = word;
            }
        }
        Arrays.sort(result);

        return result;
    }
}
