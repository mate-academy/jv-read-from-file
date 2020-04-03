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
    public String[] readFromFile(String fileName) {

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("HEI IOException caught.", e);
        }
        List<String> listResult = new ArrayList<>();
        for (String line : lines) {
            String[] splitLine = line.split(" ");
            for (String word : splitLine) {
                if (word.toLowerCase().charAt(0) == 'w') {
                    listResult.add(word.replaceAll("\\W+", "").toLowerCase());
                }
            }
        }
        String[] result = listResult.toArray(String[]::new);
        Arrays.sort(result);

        return result;
    }
}
