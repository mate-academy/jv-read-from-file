package core.basesyntax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    private static final String FIRST_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            while (inputStream.available() > 0) {
                char tmp = (char) inputStream.read();
                builder.append(tmp);
            }
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] lines = builder.toString().toLowerCase().split("\n");
        builder.delete(0, builder.length());
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.startsWith(FIRST_CHARACTER)) {
                    builder.append(word).append(" ");
                }
            }
        }
        if (builder.length() == 0) {
            return new String[]{};
        }
        String[] result = builder.toString().trim().split(" ");
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].replaceAll("\\W", "");
        }
        Arrays.sort(result);
        return result;
    }
}
