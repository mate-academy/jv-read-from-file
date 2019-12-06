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
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<String> result = new ArrayList<>();
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] singleLine = fileLine
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s");
                for (String words : singleLine) {
                    if (words.toLowerCase().startsWith("w")) {
                        result.add(words.toLowerCase());
                    }
                }
            }
            if (result.size() == 0) {
                return new String[0];
            }
            Collections.sort(result);
            String[] resultArray = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }
            return resultArray;
        } catch (IOException e) {
            return new String[0];
        }
    }
}
