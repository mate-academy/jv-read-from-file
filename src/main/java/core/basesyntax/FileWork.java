package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    static String FORMATER = "w";

    public String[] readFromFile(String fileName) {
        Path testFilePath = Paths.get(fileName);
        try {
            List<String> resultList = new ArrayList<>();
            String file = Files.readString(testFilePath)
                    .toLowerCase()
                    .trim();
            if (file.length() > 0) {
                for (String word : file.split("(\\W)(\\s*)")) {
                    if (word.substring(0, 1).equals(FORMATER)) {
                        resultList.add(word);
                    }
                }
                Collections.sort(resultList);
                return resultList.toArray(new String[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem which file");
        }
        return new String[]{};
    }
}
