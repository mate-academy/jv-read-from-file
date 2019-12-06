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
    public static final String W = "w";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] singleLine = fileLine
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s");
                for (String words : singleLine) {
                    if (words.toLowerCase().startsWith(W)) {
                        result.add(words.toLowerCase());
                    }
                }
            }
            Collections.sort(result);
        } catch (IOException e) {
        }
        return  result.toArray(String[]::new);
    }
}
