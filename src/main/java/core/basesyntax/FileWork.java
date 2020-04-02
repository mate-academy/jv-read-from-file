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
        StringBuilder scannedWords = new StringBuilder();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String oneString = scan.next();
                if (oneString.startsWith("w") || oneString.startsWith("W")) {
                    scannedWords.append(oneString
                            .toLowerCase()
                            .replaceAll("[^a-z]", ""))
                            .append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scannedWords.length() > 0
                ? Arrays.stream(scannedWords.toString().trim().split(" ")).sorted().toArray(String[]::new)
                : new String[0];
    }

}
