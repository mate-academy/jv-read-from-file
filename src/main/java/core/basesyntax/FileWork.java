package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
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
    public static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> textFromFile = null;
        try {
            textFromFile = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> words = new ArrayList<>();
        for (String line : textFromFile) {
            String cleanText = line.replaceAll("\\W", " ").toLowerCase();
            for (String word : cleanText.split(" ")) {
                if (word.startsWith(START_LETTER)) {
                    words.add(word);
                }
            }
        }
        Collections.sort(words);
        String[] sortedArray = new String[words.size()];
        sortedArray = words.toArray(sortedArray);
        return sortedArray;
    }
}
