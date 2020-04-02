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
    public String[] readFromFile(String fileName) {
        String [] checkResult = new String[0];
        StringBuilder checkDocument = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String stringBuffer = new String();
            while ((stringBuffer = reader.readLine()) != null) {
                checkDocument.append(stringBuffer);
            }
        } catch (IOException exception) {
            throw new RuntimeException("File is not found!", exception);
        }

        checkResult = checkDocument
                .toString()
                .toLowerCase()
                .replaceAll("[^a-z\\s]","")
                .split(" ");

        Arrays.sort(checkResult);

        return Arrays.stream(checkResult)
                .filter(s -> s.startsWith("w"))
                .toArray(String[]::new);
    }
}
