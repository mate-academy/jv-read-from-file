package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
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
    public String[] readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.startsWith("W") || word.startsWith("w")) {
                    stringBuilder.append(word.toLowerCase().replaceAll("[^a-z]","")).append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.length() == 0
                ? new String[0]
                : Arrays.stream(stringBuilder
                                .toString()
                                .trim()
                                .split(" "))
                                .sorted()
                                .toArray(String[]::new);
    }
}
