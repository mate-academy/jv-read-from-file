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
        StringBuilder words = new StringBuilder();
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                String word = scan.next().toLowerCase();
                if (word.startsWith("w")) {
                    words.append(word.replaceAll("[^a-z]", "")).append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        }

        if (words.length() <= 0) {
            return new String[0];
        }
        String[] text = words.toString().trim().split(" ");
        Arrays.sort(text);
        return text;
    }
}
