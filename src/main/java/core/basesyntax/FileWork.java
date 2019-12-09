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
    public static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> textFromFile = null;
        try {
            textFromFile = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> filteredWords = new ArrayList<String>();
        for (String element : textFromFile) {
            String[] oneLine = element.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
            for (String innerElement : oneLine) {
                if (innerElement.startsWith(FIRST_LETTER)) {
                    filteredWords.add(innerElement);
                }
            }
        }
        Collections.sort(filteredWords);
        return filteredWords.toArray(String[]::new);
    }
}
