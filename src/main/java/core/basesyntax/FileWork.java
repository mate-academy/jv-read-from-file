package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String result = "";
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                String[] singleLine = st
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s");
                for (String words : singleLine) {
                    if (words.toLowerCase().charAt(0) == 'w') {
                        result += words.toLowerCase() + " ";
                    }
                }
            }
            if (result.length() == 0) {
                return new String[0];
            }
            String[] arrayResult = result.split("\\s");
            Arrays.sort(arrayResult);
            return arrayResult;
        } catch (IOException e) {
            return new String[0];
        }
    }
}
