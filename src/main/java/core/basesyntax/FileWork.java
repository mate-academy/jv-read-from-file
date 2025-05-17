package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {

        String[] temp = new String[1000];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] words = line.toLowerCase().split("[^a-zA-Z]+");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        temp[count++] = word;
                    }
                }
            }
        } catch (IOException e) {
            return new String[0];
        }

        String[] result = new String[count];
        System.arraycopy(temp, 0, result, 0, count);

        Arrays.sort(result);
        return result;
    }
}
