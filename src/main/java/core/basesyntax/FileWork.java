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
    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) throws RuntimeException {

        try {
            List<String> listOfLines = Files.readAllLines(Paths.get(fileName));
            List<String> resultList = new ArrayList<>();

            for (String line : listOfLines) {
                String[] arrayOfWords = line.split(" ");
                for (String word : arrayOfWords) {
                    if ((word.substring(0, 1)).equalsIgnoreCase(LETTER)) {
                        resultList.add(word.replaceAll("[^A-Za-zА-Яа-я0-9]", "").toLowerCase());
                    }
                }
            }
            Collections.sort(resultList);
            return resultList.toArray(new String[resultList.size()]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String[]{};
    }
}
