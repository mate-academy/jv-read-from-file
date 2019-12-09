package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    private static final String W = "w";
    private static final String REGEX_NON_WORDS = "[^a-z+]";

    public String[] readFromFile(String fileName) {
        List<String> arr = new ArrayList<>();

        Path path = Paths.get(fileName);
        try {
            List<String> array = Files.readAllLines(path);
            for (String value : array) {
                String[] tmp = value.toLowerCase().split(" ");
                for (String s : tmp) {
                    if (s.startsWith(W)) {
                        arr.add(s.replaceAll(REGEX_NON_WORDS, ""));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to upload file, make sure it's exist");
        }
        String[] newArr = arr.toArray(new String[0]);
        Arrays.sort(newArr);
        return newArr;
    }
}
