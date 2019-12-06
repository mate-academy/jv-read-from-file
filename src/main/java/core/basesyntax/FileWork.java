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
    public String[] readFromFile(String fileName) {
        List<String> arrFromFile = null;
        try {
            arrFromFile = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> arrOfWordsW = new ArrayList<String>();
        for (String element : arrFromFile ){
            String[] oneLine = element.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
            for (String innerElement : oneLine) {
                if (innerElement.startsWith("w")){
                    arrOfWordsW.add(innerElement);
                }
            }
        }
        Collections.sort(arrOfWordsW);
        return arrOfWordsW.toArray(String[]::new);
    }
}
