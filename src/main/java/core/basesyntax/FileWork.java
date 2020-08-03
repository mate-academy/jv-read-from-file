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
    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            List<String> text = Files.readAllLines(Paths.get(fileName));
            for (String line : text) {
                line = line.toLowerCase().replaceAll("[\\W]", " ").trim();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.startsWith(LETTER)) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] fin = result.toArray(new String[0]);
        Arrays.sort(fin);
        return fin;
    }
}
