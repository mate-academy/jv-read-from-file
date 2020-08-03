package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    static final String CONSTANT_W = "w";

    public String[] readFromFile(String fileName) {
        try {
            String inputFileAsString = Files.readString(Paths.get(fileName));
            String cleanString = inputFileAsString.toLowerCase().replaceAll("[^a-z ]", "");
            ArrayList<String> arrayListOfWord = new ArrayList<String>();

            for (String word : cleanString.split(" ")) {
                if (word.startsWith(CONSTANT_W)) {
                    arrayListOfWord.add(word);
                }
            }

            Collections.sort(arrayListOfWord);
            return arrayListOfWord.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("have problem with reading of file");
        }
    }
}
