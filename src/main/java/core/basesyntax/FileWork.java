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

    private static final String WORDS_START_WITH = "w";

    public String[] readFromFile(String fileName) {
        Stream<String> allLines = null;
        try {
            allLines = Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return Arrays.stream(allLines.collect(Collectors.joining(" ")).split(" "))
                .map(String::toLowerCase)
                .filter(word -> word.startsWith(WORDS_START_WITH))
                .map(word -> word.replaceAll("\\W", ""))
                .sorted()
                .toArray(String[]::new);
    }
}
