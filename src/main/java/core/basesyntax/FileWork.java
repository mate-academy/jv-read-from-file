package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private static final String FIRST_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                fileContent.append(reader.readLine());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<String> listOfWords = new ArrayList<>();
        for (String word : fileContent.toString().toLowerCase().split(" ")) {
            if (word.startsWith(FIRST_CHARACTER)) {
                listOfWords.add(word.replaceAll("\\W", ""));
            }
        }
        Collections.sort(listOfWords);
        String[] result = new String[listOfWords.size()];
        return listOfWords.toArray(result);
    }
}
