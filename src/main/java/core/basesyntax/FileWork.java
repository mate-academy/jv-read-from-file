package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    static final char WORDS_START_FROM = 'w';

    public String[] readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        List<String> selectedWords = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                for (String s : buffer.split(" ")) {
                    if (s.toLowerCase().charAt(0) == WORDS_START_FROM) {
                        selectedWords.add(s.toLowerCase().replaceAll("[^a-z]", ""));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        if (selectedWords.size() == 0) {
            return new String[0];
        }
        selectedWords.sort(Comparator.naturalOrder());
        return selectedWords.toArray(new String[0]);
    }
}
