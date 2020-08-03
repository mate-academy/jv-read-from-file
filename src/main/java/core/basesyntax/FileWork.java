package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    private static final String SEARCH_LETTER = "w";
    String[] emptyArray = new String[0];
    List<String> wordsList = new ArrayList<String>();

    public String[] readFromFile(String fileName) {
        String[] words = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder result = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                result.append(line);
                line = br.readLine();
            }
            words = result.toString().split(" ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file", e);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^A-Za-z]", "");
            if (word.indexOf(SEARCH_LETTER) == 0) {
                wordsList.add(word);
            }
        }
        if (wordsList.size() == 0) {
            return emptyArray;
        }
        Collections.sort(wordsList);
        String[] result = wordsList.toArray(new String[0]);
        return result;
    }
}
