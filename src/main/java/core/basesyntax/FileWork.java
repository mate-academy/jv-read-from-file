package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
        BufferedReader textHolder;
        StringBuilder progressResult = new StringBuilder();
        try {
            textHolder = new BufferedReader(new FileReader(fileName));
            String lineFromFile;
            while ((lineFromFile = textHolder.readLine()) != null) {
                for (String element : lineFromFile.toLowerCase().split("\\W")) {
                    if (element.startsWith(WORD_START)) {
                        progressResult.append(element).append(" ");
                    }
                }
            }
            textHolder.close();
            String[] result = new String[0];
            if (progressResult.length() > 0) {
                result = progressResult.toString().split(" ");
                Arrays.sort(result);
            }
            return result;
        } catch (IOException message) {
            throw new RuntimeException(message);
        }
    }
}
