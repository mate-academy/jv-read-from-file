package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
        try {
            FileReader fileReader;
            String needStart = "w";
            fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            ArrayList<String> wordList = new ArrayList<>();
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (word.startsWith(needStart)) {
                    wordList.add(word.toLowerCase().replaceAll("[^a-z]", ""));
                }
            }
            fileReader.close();
            String[] words = wordList.toArray(String[]::new);
            Arrays.sort(words);
            return words;
        } catch (FileNotFoundException e) {
            return new String[0];
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
