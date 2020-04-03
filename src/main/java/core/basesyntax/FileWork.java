package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст
 * і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням).
 * Всі слова повинні бути в нижньому регістрі.
 * У випадку якщо таких слів не знайдено повернути пустий масив.
 * <p>
 * <p>
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public static final String START_OF_WORD = "w";

    public String[] readFromFile(String fileName) {
        String[] result = new String[0];

        try {
            String text = Files.readString(Paths.get(fileName));
            String[] words = text.toLowerCase().split(" ");
            StringBuilder wordsFromW = new StringBuilder();
            for (String i : words) {
                if (i.startsWith(START_OF_WORD)) {
                    wordsFromW.append(i.replaceAll("\\W", "")).append(" ");
                }
            }
            if (wordsFromW.length() > 0) {
                result = wordsFromW.toString().split(" ");
            }
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}


