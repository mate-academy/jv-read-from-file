package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public static final char W = 'w';

    public static String[] readFromFile(String fileName) {
        StringBuilder words = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            if (lines.isEmpty()) {
                return new String[0];
            }

            for (String line : lines) {
                String[] lineWords = line.toLowerCase().split(" ");
                for (String word : lineWords) {
                    if (word.charAt(0) == W) {
                        words.append(word.replaceAll("[^a-z]+", "")).append(" ");
                    }
                }
            }
            if (words.toString().isBlank()) {
                return new String[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result = words.toString().trim().split(" ");
        Arrays.sort(result);
        return result;
    }
}
