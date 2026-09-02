package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String text = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                text += line + " ";
            }

        } catch (IOException e) {
            return new String[0];
        }

        String[] words = text.split("\\P{L}+");

        int count = 0;

        for (String word : words) {
            String lower = word.toLowerCase();

            if (!lower.isEmpty() && lower.charAt(0) == 'w') {
                count++;
            }
        }

        String[] result = new String[count];

        int index = 0;

        for (String word : words) {
            String lower = word.toLowerCase();

            if (!lower.isEmpty() && lower.charAt(0) == 'w') {
                result[index] = lower;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
