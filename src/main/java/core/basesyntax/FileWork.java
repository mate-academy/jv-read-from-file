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
    private static final String W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder resultLine = new StringBuilder();
        try {
            try (FileReader fileReader = new FileReader(fileName);
                    BufferedReader reader = new BufferedReader(fileReader)) {
                while (reader.ready()) {
                    resultLine.append(reader.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = resultLine.toString();
        result = result.replaceAll("[^(\\sa-zA-Z)]", "");
        String[] words = result.split(" ");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().startsWith(W)) {
                list.add(word.toLowerCase());
            }
        }
        if (list.isEmpty()) {
            return new String[0];
        }
        Collections.sort(list);
        String[] arrayResult = new String[list.size()];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = list.get(i);
        }
        return arrayResult;
    }
}
