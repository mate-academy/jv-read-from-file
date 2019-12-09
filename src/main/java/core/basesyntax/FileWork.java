package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    static final String CHECK = "w";

    public String[] readFromFile(String fileName) {

        StringBuilder str = new StringBuilder();
        try
                (FileReader fileReader = new FileReader(fileName);
                 BufferedReader reader = new BufferedReader(fileReader);) {
            while (reader.ready()) {
                str.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = str.toString().replaceAll("[^\\s a-z A-Z]", "");
        String[] words = string.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().startsWith(CHECK)) {
                list.add(words[i].toLowerCase());
            }
        }
        Collections.sort(list);
        String[] result = list.toArray(new String[list.size()]);

        return result;
    }
}
