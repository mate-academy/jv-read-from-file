package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String START_OF_WORD = "w";
    private static final String SPLIT_TEXT = " ";
    private static final String CHAR_AND_SPACE_ONLY_REGEXP = "[^A-z ]";

    public String[] readFromFile(String fileName) {
        StringBuilder words = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.toLowerCase().replaceAll(CHAR_AND_SPACE_ONLY_REGEXP, "")
                        .split(SPLIT_TEXT)) {
                    if (word.startsWith(START_OF_WORD)) {
                        words.append(word).append(SPLIT_TEXT);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (words.length() != 0) {
            String[] array = words.toString().split(SPLIT_TEXT);
            Arrays.sort(array);
            return array;
        } else {
            return new String[0];
        }
    }
}
