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
    public static final char START_LETTER = 'w';

    public static String[] readFromFile(String fileName) {
        StringBuilder words = new StringBuilder();
        String [] result = new String [0];
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            for (String line : lines) {
                String[] lineWords = line.toLowerCase().split(" ");
                for (String word : lineWords) {
                    if (word.charAt(0) == START_LETTER) {
                        words.append(word.replaceAll("[^a-z]+", "")).append(" ");
                        result = words.toString().trim().split(" ");
                    }
                }
            }
            Arrays.sort(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
