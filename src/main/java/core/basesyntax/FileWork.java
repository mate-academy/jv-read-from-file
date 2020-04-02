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
    public String[] readFromFile(String fileName) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(fileName));
        List<String> listResult = new ArrayList<>();
        for (String line : lines) {
            String[] splitLine = line.split(" ");
            for (String word : splitLine) {
                if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                    listResult.add(word);
                }
            }
        }
        String[] result = new String[listResult.size()];
        for (int i = 0; i < listResult.size(); i++) {
            result[i] = listResult.get(i).toLowerCase().replaceAll("\\W+", "");
        }
        Arrays.sort(result);

        return result;
    }
}
