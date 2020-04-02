package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
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
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder words = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.startsWith("w") || word.startsWith("W")) {
                    words.append(word.toLowerCase().replaceAll("[^a-z]","")).append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words.length() == 0
                ? new String[0]
                : Arrays.stream(words.toString().trim().split(" ")).sorted().toArray(String[]::new);
    }
}
