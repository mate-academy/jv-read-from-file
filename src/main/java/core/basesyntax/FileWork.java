package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder searchedWords = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                String[] buffuredWords = line.toLowerCase()
                        .replaceAll("[^a-z]", " ")
                        .trim().split(" ");
                for (String word: buffuredWords) {
                    if (word.startsWith("w")) {
                        searchedWords.append(word).append(" ");
                    }
                }
            }
            if (!searchedWords.toString().isEmpty()) {
                result = searchedWords.toString().trim().split(" ");
                Arrays.sort(result);
            }
        } catch (IOException e) {
            System.out.println("Sorry =(");
        }
        return result;
    }
}
