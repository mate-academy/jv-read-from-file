package core.basesyntax;

import java.io.BufferedReader;

import java.io.FileReader;
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
        List<String> resultList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String strFile;
            while ((strFile = bufferedReader.readLine()) != null) {
                String[] strFileWords = strFile.toLowerCase().split("[,;:.!?\\s]+");
                for (String item : strFileWords) {
                    if (item.startsWith("w")) {
                        resultList.add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(resultList);
        return resultList.toArray(new String[resultList.size()]);
    }
}
