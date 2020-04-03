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
    private static final String WORD_START_FROM = "w";

    public String[] readFromFile(String fileName) {
        String[] resultWords = new String[0];
        try {
            Path readFile = Paths.get(fileName);
            String line = Files.readString(readFile);
            String[] lineSplit = line.split(" ");
            StringBuilder result = new StringBuilder();
            for (String eachWordInLine : lineSplit) {
                if (eachWordInLine.toLowerCase().startsWith(WORD_START_FROM)) {
                    eachWordInLine = eachWordInLine.toLowerCase().replaceAll("\\W", "");
                    result.append(eachWordInLine).append(" ");
                }
            }
            if (result.length() > 0) {
                resultWords = result.toString().split(" ");
                Arrays.sort(resultWords);
            } else {
                return resultWords;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultWords;
    }
}
