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
    static final String LETTER = "w";
    static final String POINT = ".";
    static final String EMPTY = "";
    static final String SPACE = " ";
    static final String EXCLAMATION_MARK = "!";
    static final String QUESTION_MARK = "?";

    public String[] readFromFile(String fileName) {
        String tempString = EMPTY;
        String[] result;
        try (BufferedReader newReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = newReader.readLine()) != null) {
                String[] arr1 = line.toLowerCase().split(SPACE);
                for (String line2 : arr1) {
                    if (line2.substring(0, 1).equals(LETTER)) {
                        tempString += line2.replace(POINT, EMPTY).replace(QUESTION_MARK, EMPTY)
                                .replace(EXCLAMATION_MARK, EMPTY) + SPACE;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Where is the file?", e);
        }
        if (tempString.equals(EMPTY)) {
            return new String[0];
        }
        result = tempString.split(SPACE);
        Arrays.sort(result);
        return result;
    }
}
