package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private static final String SMALL_LETTER_W = "w";

    public String[] readFromFile(String fileName) throws RuntimeException {
        try {
            List<String> sortedWordsWithW = new ArrayList<>();
            for (String line : Files.readAllLines(Paths.get(fileName))) {
                for (String word : line.toLowerCase().split(" ")) {
                    if (word.startsWith(SMALL_LETTER_W)) {
                        sortedWordsWithW.add(word.replaceAll("\\W+", ""));
                    }
                }
            }
            Collections.sort(sortedWordsWithW);
            String[] result = sortedWordsWithW.toArray(new String[0]);
            return result;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
