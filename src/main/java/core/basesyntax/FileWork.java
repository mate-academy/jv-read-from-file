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
    private static final String FIRSTCHAR = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder startsWithW = new StringBuilder();
        String[] result;
        try {
            String allFile = Files.readString(Paths.get(fileName)).toLowerCase();
            String[] words = allFile.split(" ");
            for (String word : words) {
                if (word.startsWith(FIRSTCHAR)) {
                    startsWithW.append(word.replaceAll("\\W", "")).append(" ");
                }
            }
            result = startsWithW.length() > 0 ? startsWithW.toString().split(" ") : new String[0];
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

