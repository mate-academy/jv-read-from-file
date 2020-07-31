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
        List<String> text = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String[] allText = br.readLine().split(" ");

                for (String s : allText) {
                    if (s.startsWith("w") || s.startsWith("W")) {
                        text.add(s.toLowerCase().replaceAll("[^a-z]", ""));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        Collections.sort(text);
        return text.toArray(new String[0]);
    }
}
