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
    private static final String LETTER = "w";
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder tempString = new StringBuilder();
        String[] result;
        try (BufferedReader newReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = newReader.readLine()) != null) {
                String[] arr1 = line.toLowerCase().split(SPACE);
                for (String line2 : arr1) {
                    if (line2.startsWith(LETTER)) {
                        tempString.append(line2.replaceAll("[^a-z0-9]", "") + SPACE);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Where is the file?", e);
        }
        if (tempString.length() == 0) {
            return new String[0];
        }

        result = tempString.toString().trim().split(" ");
        Arrays.sort(result);
        return result;
    }
}
