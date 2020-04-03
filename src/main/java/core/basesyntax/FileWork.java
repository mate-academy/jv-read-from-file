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
    private static final String FIRST_CHAR = "w";

    public static String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String text = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                text += bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] arrayOfWords = text.toLowerCase().split(" ");
        Arrays.sort(arrayOfWords);
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (arrayOfWords[i].startsWith(FIRST_CHAR)) {
                sb.append(arrayOfWords[i].replaceAll("\\W", "") + " ");
            }
        }
        return sb.length() == 0 ? new String[]{} : sb.toString().split(" ");
    }
}
