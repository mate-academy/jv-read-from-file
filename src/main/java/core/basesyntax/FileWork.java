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

    public String[] readFromFile(String fileName) {
        try {
            String[] words = Files.readString(Paths.get(fileName))
                    .toLowerCase()
                    .split(" ");
            StringBuilder wordsWithW = new StringBuilder();
            for (String word : words) {
                if (word.startsWith(FIRST_LETTER)) {
                    wordsWithW.append(word.replaceAll("\\W","")).append(" ");
                }
            }
            if (wordsWithW.length() > 0) {
                String[] result;
                result = wordsWithW.toString().split(" ");
                Arrays.sort(result);
                return result;
            } else {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("File not create", e);
        }
    }
}
