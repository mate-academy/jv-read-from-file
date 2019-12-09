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

    public String[] readFromFile(String fileName) {
        String stringFile = null;
        try {
            stringFile = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] temp = stringFile.toLowerCase().replaceAll("[^a-z]+", " ").split(" ");
        List<String> list = new ArrayList<>();

        for (String s : temp) {
            if (s.startsWith(LETTER)) {
                list.add(s);
            }
        }

        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
}
