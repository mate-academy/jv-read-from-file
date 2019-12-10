package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public static final String FIRST_CHAR = "w";

    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<String> searchedWords = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] bufferedWords = line.toLowerCase()
                        .replaceAll("[^a-z]", " ")
                        .split(" ");
                for (String word: bufferedWords) {
                    if (word.startsWith(FIRST_CHAR)) {
                        searchedWords.add(word);
                    }
                }
            }
            result = searchedWords.toArray(String[]::new);
            Arrays.sort(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
