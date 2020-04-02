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
    private static final String PATTERN = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            String string = Files.readString(Paths.get(fileName));
            String[] stringArray = string.toLowerCase().split(" ");
            for (String s : stringArray) {
                if (s.startsWith(PATTERN)) {
                    sb.append(s.replaceAll("\\W", "")).append(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.length() > 0
                ? Arrays.stream(sb.toString().trim().split(" ")).sorted().toArray(String[]::new)
                : new String[0];
    }
}
