package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    private static final String CONSTANT = "w";

    public String[] readFromFile(String fileName) {

        List<String> resultList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            {
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    String[] result = temp.toLowerCase().replaceAll("[^a-z]", " ").split(" ");
                    for (String s : result) {
                        if (s.startsWith(CONSTANT)) {
                            resultList.add(s);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(resultList);
        String[] results = new String[resultList.size()];
        return resultList.toArray(results);
    }
}
