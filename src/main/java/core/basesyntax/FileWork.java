package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

        String[] empty = new String[0];
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.getMessage();
        }
        if (lines.size() == 0) {
            return empty;
        }
        String oneSmallLineOfAllWords = lines.toString().toLowerCase()
                .replaceAll("[^a-zA-Z]+", " ");

        String[] linesToArrayString = oneSmallLineOfAllWords.trim().split(" ");
        Arrays.sort(linesToArrayString);

        int counter = 0;
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < linesToArrayString.length; i++) {
            if (linesToArrayString[i].charAt(0) == 'w') {
                words.append(linesToArrayString[i] + " ");
                counter++;
            }
        }
        String[] returnedWords = words.toString().trim().split(" ");

        if (counter == 0) {
            return empty;
        }
        return returnedWords;
    }
}
