package core.basesyntax;

import java.io.File;
import java.io.IOException;
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
        File file = new File(fileName);
        ArrayList<String> textFromFile = new ArrayList<>();
        final char StartsWith = 'w';
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] words = sc.nextLine().toLowerCase().split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].startsWith(String.valueOf(StartsWith))) {
                        textFromFile.add(words[i].replaceAll("[^a-z]", ""));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file ", e);
        }
        String[] finalStr = textFromFile.toArray(new String[textFromFile.size()]);
        Arrays.sort(finalStr);
        return finalStr;
    }
}
