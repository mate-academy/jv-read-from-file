package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String START_OF_WORD = "w";
    private static final String CHAR_AND_SPACE_ONLY_REGEXP = "[^A-z ]";

    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = readStringFromFile(br);
            while (line != null) {
                for (String word : line.toLowerCase().replaceAll(CHAR_AND_SPACE_ONLY_REGEXP, "")
                        .split(" ")) {
                    if (word.startsWith(START_OF_WORD)) {
                        words.add(word);
                    }
                }
                line = readStringFromFile(br);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        words.sort(String::compareTo);
        String[] array = new String[words.size()];
        words.toArray(array);
        return array;
    }

    private String readStringFromFile(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
