package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    static final String SEARCH_LETTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> resultList = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                list.add(reader.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        for (String str : list) {
            str = str.toLowerCase();
            String[] stringArray = str.split("\\W");
            for (String search : stringArray) {
                if (search.startsWith(SEARCH_LETTER)) {
                    resultList.add(search);
                }
            }
        }
        String[] result = resultList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
