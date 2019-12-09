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
    public static final char START_LETTER = 'w';

    public static String[] readFromFile(String fileName) {
        ArrayList<String> result = new ArrayList<>(0);

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            for (String line : lines) {
                String[] lineWords = line.toLowerCase().split(" ");
                for (String word : lineWords) {
                    if (word.charAt(0) == START_LETTER) {
                        result.add(word.replaceAll("[^a-z]+", ""));

                    }
                }
            }
            Collections.sort(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toArray(String[]::new);
    }
}
