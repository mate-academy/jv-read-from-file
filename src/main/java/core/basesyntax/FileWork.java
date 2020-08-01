package core.basesyntax;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що
 * починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням).
 * Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути
 * пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    static final String FIRST_LETTER_W = "w";

    public String[] readFromFile(String fileName) {
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get(fileName), UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> wordsStartingWithW = new ArrayList<String>();
        for (String line : lines) {
            String[] words =
                    line.replaceAll("[^A-Za-z ]", "").toLowerCase().split(" ");
            for (String word : words) {
                if (word.startsWith(FIRST_LETTER_W)) {
                    wordsStartingWithW.add(word);
                }
            }
        }
        String[] result = new String[wordsStartingWithW.size()];
        Arrays.sort(wordsStartingWithW.toArray(result));
        return result;
    }
}
