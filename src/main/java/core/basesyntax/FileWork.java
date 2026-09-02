package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        // Розбиваємо текст на слова, ігноруючи всі символи, крім букв і цифр
        String[] allWords = builder.toString().split("\\W+");
        // Перший прохід — підраховуємо скільки слів починається з букви "w"
        int count = 0;
        for (String word : allWords) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }
        // Створюємо новий масив саме на ту кількість слів, що починаються з "w"
        String[] result = new String[count];
        int index = 0; // Індекс для вставки слів у новий масив

        // Другий прохід — заповнюємо результативний масив словами на "w"
        for (String word : allWords) {
            if (word.toLowerCase().startsWith("w")) {
                result[index++] = word.toLowerCase();
            }
        }
        Arrays.sort(result);
        return result;
    }
}
