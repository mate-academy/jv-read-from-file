package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    private static final String KEY_LETTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList result = new ArrayList();
        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase()
                        .replaceAll("[^a-z]", " ")
                        .split(" ");
                for (String word : words) {
                    if (word.startsWith(KEY_LETTER)) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("There isn't such file");
        }
        Collections.sort(result);
        String[] readFromFile = new String[result.size()];
        return (String[]) result.toArray(readFromFile);
    }
}
