package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    public String[] readFromFile(String fileName) {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<String> words = lines
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> word.startsWith("W") || word.startsWith("w"))
                    .map(word -> word.replaceAll("\\W", "").toLowerCase())
                    .collect(Collectors.toList());
            Collections.sort(words);
            return words.toArray(new String[] {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
