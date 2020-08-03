package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */

public class FileWork {
    public static final String LETTER = "w";

    public static String[] readFromFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(fileReader);

            StringBuilder text = new StringBuilder("");
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine() + " ");
            }
            String[] words = text.toString().split(" ");
            String resultString = "";

            int index = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].toLowerCase().startsWith(LETTER)) {
                    resultString += words[i].toLowerCase().replaceAll("[^\\w\\s]|_", "") + " ";
                }
            }
            String[] result = resultString.trim().split(" ");
            Arrays.sort(result);

            return result[0] != "" ? result : new String[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
