package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        try {
            Path filePath = Paths.get(fileName);
            List<String> listOfAllLines = Files.readAllLines(filePath);
            StringBuilder readText = new StringBuilder();
            for (String i : listOfAllLines) {
                readText.append(i).append(" ");
            }
            String newText = readText.toString().trim().toLowerCase().replaceAll("[^a-z]", " ");
            String[] split = newText.split(" ");
            ArrayList<String> listOfWords = new ArrayList<>();
            for (String i : split) {
                if (i.startsWith("w")) {
                    listOfWords.add(i);
                }
            }
            Collections.sort(listOfWords);
            return listOfWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
