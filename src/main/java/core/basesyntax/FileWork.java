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
    public String[] readFromFile(String fileName) {
        StringBuilder textAll = new StringBuilder();
        StringBuilder textCleaned = new StringBuilder();
        try {
            Scanner scan = new Scanner(new FileReader(fileName));
            while (scan.hasNextLine()) {
                textAll.append(scan.nextLine());
            }
            scan.close();
        } catch (IOException e) {
            throw new RuntimeException("File not founded", e);
        }
        if (textAll.length() == 0) {
            return new String[]{};
        }
        String[] all = textAll.toString().toLowerCase().split(" ");
        Arrays.sort(all);
        for (String i : all) {
            if (((Character) i.charAt(0)).equals('w')) {
                i = i.replaceAll("[^\\w]", "");
                textCleaned.append(i).append(" ");
            }
        }
        return textCleaned.length() > 0 ? textCleaned.toString().split(" ") : new String[]{};
    }
}
