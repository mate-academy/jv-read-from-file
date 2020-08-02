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
    private static final String WORD_START = "w";

    public String[] readFromFile(String fileName) {
        List<String> resultList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.startsWith(WORD_START)) {
                        word = word.replaceAll("\\W", "");
                        resultList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] resultMas = resultList.toArray(new String[0]);
        Arrays.sort(resultMas);
        return resultMas;
    }
}
