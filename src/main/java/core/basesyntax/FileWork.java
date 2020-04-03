package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    public static final String STARTS_WITH = "w";

    public static String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            lines.forEach(line -> {
                Arrays.stream(line.split("\\s+"))
                        .map(String::toLowerCase)
                        .filter(w -> w.startsWith(STARTS_WITH))
                        .map(w -> w.replaceAll("\\W", ""))
                        .forEach(w -> result.append(w).append(" "));
            });
            return result.length() == 0 ? new String[] {}
                    : Arrays.stream(result.toString().split(" "))
                    .sorted().collect(Collectors.toList()).toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
