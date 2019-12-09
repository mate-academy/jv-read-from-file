package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    public static final String OBJECT_SEACHER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File(fileName)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                buffer.append(line);
                line = bufferedReader.readLine();
            }
            if (buffer.toString().isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String[] wordsSeacher = buffer.toString().toLowerCase().split(" ");
        StringBuilder fishWords = new StringBuilder();
        for (String i : wordsSeacher) {
            if (i.startsWith(OBJECT_SEACHER)) {
                fishWords.append(i.replaceAll("[^a-z]+", "")).append(" ");
            }
        }
        if (fishWords.toString().isBlank()) {
            return new String[0];
        }
        String[] finishArray = fishWords.toString().trim().split(" ");
        Arrays.sort(finishArray);
        return finishArray;
    }
}
