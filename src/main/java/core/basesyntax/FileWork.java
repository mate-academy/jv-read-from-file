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
        StringBuilder readText = new StringBuilder();
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            while (bufferedReader.ready()) {
                readText.append((char) bufferedReader.read());
            }

            for (String word : readText
                    .toString()
                    .toLowerCase()
                    .split("\\W+")) {
                if (word.startsWith("w")) {
                    result.add(word);
                }
            }

            Collections.sort(result);
            return result.toArray(new String[result.size()]);

        } catch (IOException exception) {
            System.out.println("ex");
        }
        return null;
    }
}
