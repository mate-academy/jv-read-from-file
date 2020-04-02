package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        String[] arr = new String[0];
        try {
            arr = Files.readString(Path.of(fileName)).toLowerCase().split("\\W+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.indexOf('w') == 0) {
                list.add(s);
            }
        }
        Collections.sort(list);
        String[] output = new String[list.size()];
        return list.toArray(output);
    }
}
