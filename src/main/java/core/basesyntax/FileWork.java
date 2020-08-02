package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    static final char W_CONSTANT = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder resultBuilder = new StringBuilder();
        String[] result;
        Path path = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split(" ");
                for (String word : words) {
                    if (word.charAt(0) == W_CONSTANT) {
                        resultBuilder.append(word.replaceAll("[^\\w]", "")).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = resultBuilder.toString().trim().split(" ");
        Arrays.sort(result);
        return result[0].equals("") ? new String[0] : result;
    }
}
