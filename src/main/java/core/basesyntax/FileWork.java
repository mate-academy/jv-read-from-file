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

    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> container = new ArrayList<>();
        try {
            String text = Files.readString(Paths.get(fileName));
            String[] words = text.toLowerCase().replaceAll("[^a-z]+", " ").split(" ");
            for (String word : words) {
                if (word.startsWith(LETTER)) {
                    container.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(container);
        return container.toArray(new String[0]);
    }
}
