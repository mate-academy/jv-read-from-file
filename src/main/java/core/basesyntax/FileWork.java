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

    public static final String LETTER = "w";

    String[] readFromFile(String fileName) {

        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                String[] words = nextLine.toLowerCase()
                        .replaceAll("\\W+", " ")
                        .split(" ");
                for (String str : words) {
                    if (str.startsWith(LETTER)) {
                        result.append(str).append(" ");
                    }
                }
            }
            String[] resultString = result.toString().split(" ");
            if (resultString[0].equals("")) {
                return new String[0];
            }
            Arrays.sort(resultString);
            return resultString;
        } catch (IOException e) {
            throw new RuntimeException("File not found! " + e);
        }
    }
}
