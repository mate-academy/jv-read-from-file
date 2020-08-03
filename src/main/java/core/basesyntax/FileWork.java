package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    private static final String FIRST_CHAR = "w";

    public static String[] readFromFile(String fileName) {
        String fileText = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null) {
                fileText += oneLine;
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong! We can't read this file");
        }
        return fileText.equals("") ? new String[0] : Stream.of(fileText.split(" "))
                .map(word -> word.toLowerCase())
                .map(word -> word.replaceAll("(\\W*)(\\s*)", ""))
                .filter(word -> word.startsWith(FIRST_CHAR))
                .sorted(String::compareTo)
                .toArray(String[]::new);
    }
}
