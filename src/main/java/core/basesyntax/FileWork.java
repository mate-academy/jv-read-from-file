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
    public static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) throws Exception {

        String[] result;
        try {
            String text = Files.readString(Paths.get(fileName));
            String[] words = text.toLowerCase().split(" ");
            StringBuilder builder = new StringBuilder();
            for (String word : words) {
                if (word.startsWith(FIRST_LETTER)) {
                    builder.append(word.replaceAll("\\W", "")).append(" ");
                }
            }
            result = builder.length() > 0 ? builder.toString().split(" ") : new String[0];
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("There is no such file", e);
        }

        return result;
    }
}
