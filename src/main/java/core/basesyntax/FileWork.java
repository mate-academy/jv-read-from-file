package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
    private final String checkingLetter = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            Path path = Paths.get("jv-read-from/../" + fileName);
            byte[] file = Files.readAllBytes(path);
            for (String str : new String(file, StandardCharsets.UTF_8).split(" ")) {
                if (str.toLowerCase().startsWith(checkingLetter)) {
                    result.append(str.toLowerCase().replaceAll("\\W", "") + " ");
                }
            }
            String[] resultArray = result.toString().split(" ");
            if (resultArray.length == 1 && resultArray[0].equals("") || resultArray.length == 0) {
                return new String[0];
            }
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new String[]{};
    }
}
