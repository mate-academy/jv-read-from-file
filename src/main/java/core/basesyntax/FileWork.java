package core.basesyntax;

import java.io.FileNotFoundException;
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
        List<String> stringsFromFile = null;
        try {
            stringsFromFile = Files.readAllLines(Paths.get(fileName));
        } catch (FileNotFoundException e) {
            return new String[0];
        } catch (IOException e) {
            throw new RuntimeException("Not valid data", e);
        }
        StringBuilder wordsStartsWithW = new StringBuilder();
        for (String oneString : stringsFromFile) {
            oneString = oneString.toLowerCase().replaceAll("\\p{P}", "");
            String[] words = oneString.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].charAt(0) == 'w') {
                    wordsStartsWithW = wordsStartsWithW.append(words[i]).append(" ");
                }
            }
        }
        if (wordsStartsWithW.length() == 0) {
            return new String[0];
        }
        String[] sortWords = wordsStartsWithW.toString().split("\\s");
        Arrays.sort(sortWords);
        return sortWords;
    }
}
