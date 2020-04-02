package core.basesyntax;

import java.io.File;
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
    public static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder scannedWords = new StringBuilder();
        String[] result;
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String oneString = scan.next().toLowerCase();
                if (oneString.startsWith(CHARACTER)) {
                    scannedWords.append(oneString.replaceAll("\\W", "")).append(" ");
                }
            }
            result = scannedWords.length() > 0
                    ? Arrays.stream(scannedWords.toString().trim()
                    .split(" ")).sorted().toArray(String[]::new)
                    : new String[0];
        } catch (IOException e) {
            throw new RuntimeException("Неверно указано имя файла, или его не существует", e);
        }
        return result;
    }
}
