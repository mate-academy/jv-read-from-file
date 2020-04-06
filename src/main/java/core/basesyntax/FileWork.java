package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public static final String LETTER_W_IN_LOWER_CASE  = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String[] result;

        try {
            Path filePath = Paths.get(fileName);
            String content = Files.readString(filePath).toLowerCase();
            String[] words = content.split(" ");
            for (String word: words) {
                if (word.startsWith(LETTER_W_IN_LOWER_CASE)) {
                    sb.append(word.replaceAll("\\W", "")).append(" ");
                }
            }
            result = sb.toString().split(" ");
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        return sb.length() > 0 ? result : new String[0];
    }
}
