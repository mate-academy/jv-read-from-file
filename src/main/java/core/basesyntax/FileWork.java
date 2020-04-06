package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    private static final String LETTER = "w";

    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        } finally {
            List<String> wordsList = new ArrayList<>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] temp = line.split(" ");
                for (String word : temp) {
                    if (word.toLowerCase().startsWith(LETTER)) {
                        wordsList.add(word.toLowerCase().replaceAll("[^a-z\\s]", ""));
                    }
                }
            }
            Collections.sort(wordsList);
            return wordsList.toArray(new String[wordsList.size()]);
        }
    }
}
