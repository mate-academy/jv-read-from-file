package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            StringBuilder content = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            reader.close();

            String[] words = content.toString().split("\\W+");
            String[] tempArray = new String[words.length];
            int count = 0;

            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    tempArray[count] = word.toLowerCase();
                    count++;
                }
            }

            if (count == 0) {
                return new String[0];
            }

            String[] result = new String[count];
            System.arraycopy(tempArray, 0, result, 0, count);

            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new String[0];
        }
    }
}
