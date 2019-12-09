package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    static final char LETTER = 'w';

    public String[] readFromFile(String fileName) {
        String text = null;
        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (text.length() == 0) {
            return new String[0];
        }
        String[] words = text.toLowerCase().replaceAll("[^a-z]+", " ").split(" ");
        StringBuilder newContainer = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == LETTER) {
                newContainer.append(word + " ");
            }
        }
        if (newContainer.length() == 0) {
            return new String[0];
        }
        String[] result = newContainer.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
