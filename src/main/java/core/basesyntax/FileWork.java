package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
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

    public static final String OBJECT_SEARCHER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File(fileName)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                buffer.append(line);
                line = bufferedReader.readLine();
            }
            if (buffer.toString().isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String[] wordsSearcher = buffer.toString()
                .toLowerCase()
                .replaceAll("[^a-z]+"," ")
                .split(" ");

        List<String> result = new ArrayList<>();
        for (String i : wordsSearcher) {
            if (i.startsWith(OBJECT_SEARCHER)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }
}
