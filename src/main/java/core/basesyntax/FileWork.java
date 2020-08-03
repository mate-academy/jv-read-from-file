package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String FIRST_CHAR = "w";

    public String[] readFromFile(String fileName) {
        List<String> lines;
        List<String> list = new ArrayList<>();
        String[] result = list.toArray(new String[0]);

        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }

        for (String s : lines) {
            String[] words = s.toLowerCase().split("\\W");

            for (String word : words) {
                if (word.startsWith(FIRST_CHAR)) {
                    list.add(word);
                }
            }
        }
        Arrays.sort(result);

        return result;
    }
}
