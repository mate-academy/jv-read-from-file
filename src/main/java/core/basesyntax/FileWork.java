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

    public static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String [] result;
        StringBuilder checkDocument = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String cheakLines;
            while ((cheakLines = reader.readLine()) != null) {
                checkDocument.append(cheakLines);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        result = checkDocument
                .toString()
                .toLowerCase()
                .replaceAll("[^a-z\\s]","")
                .split(" ");

        Arrays.sort(result);

        return Arrays.stream(result)
                .filter(s -> s.startsWith(START_LETTER))
                .toArray(String[]::new);
    }
}
