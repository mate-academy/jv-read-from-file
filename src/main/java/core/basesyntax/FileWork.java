package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */

public class FileWork {
    private static final char LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            List<String> wordList = new ArrayList<String>();
            while ((line = fileReader.readLine()) != null) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
                for (String word : words) {
                    if (word.charAt(0) == LETTER) {
                        wordList.add(word);
                    }
                }
            }
            if (wordList.size() == 0) {
                return new String[]{};
            }
            Collections.sort(wordList);
            return wordList.toArray(new String[wordList.size()]);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
