package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                contentBuilder.append(line).append(" ");
            }
            String content = contentBuilder.toString();
            String[] words = content.split("[\\s,.!?]+");
            String[] result = new String[words.length];
            int count = 0;

            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    result[count++] = word.toLowerCase();
                }
            }

            // Сортування масиву
            Arrays.sort(result, 0, count);

            // Створення масиву результатів правильної довжини
            String[] finalResult = new String[count];
            System.arraycopy(result, 0, finalResult, 0, count);

            return finalResult;
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
