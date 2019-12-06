package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private static final String KEYWORD = "w";

    public String[] readFromFile(String fileName) {
        String stringsFromFile = "";
        try {
            stringsFromFile = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] result = stringsFromFile.toLowerCase().replaceAll("[^A-Za-z]", " ").split(" ");

        List<String> wordsWithW = new ArrayList<>();

        for (String word : result) {
            if (word.startsWith(KEYWORD)) {
                wordsWithW.add(word);
            }
        }

        Collections.sort(wordsWithW);
        return wordsWithW.toArray(new String[wordsWithW.size()]);
    }
}
