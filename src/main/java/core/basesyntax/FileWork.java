package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> rowOfText = null;
        try {
            rowOfText = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        List<String> arrayList = new ArrayList<>();
        for (String line : rowOfText) {
            line = line.toLowerCase();
            String[] lines = line.split("\\W");
            for (String words : lines) {
                if (words.startsWith(LETTER)) {
                    arrayList.add(words);
                }
            }
        }
        String[] neededWords = arrayList.toArray(new String[arrayList.size()]);
        Arrays.sort(neededWords);
        return neededWords;
    }
}
