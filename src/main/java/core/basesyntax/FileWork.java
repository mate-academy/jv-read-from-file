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
    private final String REGEX = "\\W";

    public String[] readFromFile(String fileName) {
        final Path PATH = Paths.get(fileName);
        try {
            if (Files.exists(PATH)
                    && Files.isReadable(PATH)
                    && Files.size(PATH) > 0) {
                return Arrays.stream(Files.readString(PATH).split(" "))
                        .map(e -> e.toLowerCase().replaceAll(REGEX, ""))
                        .filter(e -> e.startsWith("w"))
                        .sorted()
                        .toArray(String[]::new);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String[0];
    }
}
