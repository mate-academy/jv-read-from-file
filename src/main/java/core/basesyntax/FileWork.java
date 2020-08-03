package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */

public class FileWork {
    private static final String LETTERW = "w";

    public String[] readFromFile(String fileName) {
        List<String> allWordsWithW = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                line = line.toLowerCase();
                line = line.replaceAll("[^a-z]", " ");
                String[] separateWords = line.split("\\s+");
                for (String word : separateWords) {
                    if (word.startsWith(LETTERW)) {
                        allWordsWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("A file not found", e);
        }

        String[] result = allWordsWithW.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
