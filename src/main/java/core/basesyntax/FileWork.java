package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
            String[] allWorlds = stringBuilder.toString().toLowerCase().split("\\W+");

            int count = 0;
            for (String word : allWorlds) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    count++;
                }
            }
            String[] result = new String[count];
            int index = 0;
            for (String word : allWorlds) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    result[index] = word;
                    index++;
                }
            }
            Arrays.sort(result);
            return result;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Error riding file" + fileName, e);
        }

    }
}
