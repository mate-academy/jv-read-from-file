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
    private static final String REGEX = "\\W";
    private static final String LETTER = "w";
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    public String[] readFromFile(String fileName) {
        final Path path = Paths.get(fileName);
        try {
            if (Files.exists(path)
                    && Files.isReadable(path)
                    && Files.size(path) > 0) {
                return Arrays.stream(Files.readString(path).split(SPACE))
                        .map(e -> e.toLowerCase().replaceAll(REGEX, EMPTY_STRING))
                        .filter(e -> e.startsWith(LETTER))
                        .sorted()
                        .toArray(String[]::new);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String[0];
    }
}
