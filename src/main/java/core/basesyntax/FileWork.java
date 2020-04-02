package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
        if (fileName.isEmpty()) {
            return new String[]{};
        }
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fr);
        ArrayList<String> sb = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.startsWith("W") || word.startsWith("w")) {
                sb.add(word.toLowerCase().replaceAll("[^a-z]",""));
            }
        }
        String[] words = sb.toArray(String[]::new);
        Arrays.sort(words);
        return words;
    }
}

