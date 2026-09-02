package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER1 = "w";

    public String[] readFromFile(String fileName) {
        String[] wordsArray = new String[10]; // Початковий розмір масиву
        int index = 0; // Індекс для запису в масив

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок на слова
                String[] words = line.split("\\W+");

                // Заміна циклу for-each на for з індексами
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];

                    // Перевірка, чи слово починається з 'w' (незалежно від регістру)
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER1)) {
                        // Якщо масив заповнений, збільшуємо його розмір
                        if (index == wordsArray.length) {
                            wordsArray = Arrays.copyOf(wordsArray, wordsArray.length * 2);
                            // Збільшуємо масив вдвічі
                        }
                        wordsArray[index++] = word.toLowerCase(); // Додаємо слово в масив
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        // Створюємо остаточний масив із правильним розміром
        String[] result = Arrays.copyOf(wordsArray, index);

        // Сортуємо масив
        Arrays.sort(result);

        return result;
    }
}
