package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private static final String LETTER_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNext()) {
                String textLine = scanner.next().toLowerCase();
                if (textLine.startsWith(LETTER_W)) {
                    sb.append(textLine.replaceAll("[^a-z]", "")).append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
        if (sb.length() == 0) {
            return new String[0];
        }
        String[] fin = sb.toString().trim().split(" ");
        Arrays.sort(fin);
        return fin;
    }
}
