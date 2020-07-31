package core.basesyntax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

    private static final String CONSTANTECHAR = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            Path paths = Paths.get(fileName);
            File file = paths.toFile();
            InputStream inputStream = new FileInputStream(file);

            while (inputStream.available() > 0) {
                char tmp = (char) inputStream.read();
                builder.append(tmp);
            }
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] words = builder.toString().toLowerCase().split(" ");
        int count = 0;
        for (String word : words) {
            if (word.startsWith(CONSTANTECHAR)) {
                ++count;
            }
        }
        String[] result = new String[count];
        count = 0;
        for (String word : words) {
            if (word.startsWith(CONSTANTECHAR)) {
                result[count] = word.replaceAll("\\W", "");
                ++count;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
