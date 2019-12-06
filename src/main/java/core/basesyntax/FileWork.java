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
    final String firstLetter = "w";

    public String[] readFromFile(String fileName) throws IOException {
        String stringFile = Files.readString(Paths.get(fileName));
        String[] temp = stringFile.toLowerCase().replaceAll("[^a-z]+", " ").split(" ");
        List<String> list = new ArrayList<>();

        for (String s : temp) {
            if (s.startsWith(firstLetter)) {
                list.add(s);
            }
        }

        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
}
