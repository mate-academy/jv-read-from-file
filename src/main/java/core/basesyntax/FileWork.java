package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private final String identifier = "w";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] wordsFromLine = reader.readLine().split(" ");

                for (String word : wordsFromLine) {
                    if (word.toLowerCase().startsWith(identifier)) {
                        result.add(word.toLowerCase().replaceAll("[^a-z]", ""));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
