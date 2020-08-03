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
    public String[] readFromFile(String fileName) {
        Path pathToFile = Paths.get(fileName);
        if (Files.exists(pathToFile) & Files.isReadable(pathToFile)) {
            try {
                return Arrays.stream(Files.readString(pathToFile)
                        .split("\\W")).map(String::toLowerCase)
                        .filter(x -> x.startsWith("w")).sorted().toArray(String[]::new);
            } catch (IOException e) {
                throw new RuntimeException("Exception when reading a file !!!");
            }
        }
        return new String[0];
    }
}
