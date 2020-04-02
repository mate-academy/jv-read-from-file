package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String [] arrayResult = new String[0];
        StringBuilder allDocument = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String myStringBuffer = new String();
            while ((myStringBuffer = reader.readLine()) != null) {
                allDocument.append(myStringBuffer);
            }
        } catch (IOException e) {
            throw new RuntimeException("There is no such file", e);
        }
        arrayResult = allDocument
                .toString()
                .toLowerCase()
                .replaceAll("[^a-z\\s]","")
                .split(" ");
        Arrays.sort(arrayResult);
        return Arrays.stream(arrayResult)
                .filter(s -> s.startsWith(FIRST_LETTER))
                .toArray(String[]::new);
    }
}