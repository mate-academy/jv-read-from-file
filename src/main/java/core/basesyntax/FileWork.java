package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String FIRST_CHARACTER_VALUE = "w";

    public String[] readFromFile(String fileName) {
        List<String> resultList = new ArrayList<>();
        List<String> lines = null;

        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("There are no such file.", e);
        }
        for (String line : lines) {
            String[] wordArray = line.split(" ");
            for (String word : wordArray) {
                if (word.toLowerCase().startsWith(FIRST_CHARACTER_VALUE)) {
                    resultList.add(word.toLowerCase().replaceAll("[\\W+]", ""));
                }
            }
        }
        if (resultList.size() == 0) {
            return new String[]{};
        }
        Collections.sort(resultList);
        return resultList.toArray(new String[resultList.size()]);
    }
}
