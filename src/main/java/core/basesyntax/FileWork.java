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
    public static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> resultArray = new ArrayList<>();
        try {
            List<String> stringList = Files.readAllLines(Paths.get(fileName));
            for (String string : stringList) {
                String[] words = string.toLowerCase().split(" ");
                for (String word : words) {
                    if (word.startsWith(LETTER)) {
                        resultArray.add(word.replaceAll("[^a-z]+", ""));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(resultArray);
        return resultArray.toArray(new String[resultArray.size()]);
    }
}

