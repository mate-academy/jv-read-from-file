package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public String[] readFromFile(String fileName) {
        StringBuilder fileText = new StringBuilder();
        Path filePath = Paths.get(fileName);
        List<String> list = null;

        try {
            list = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        for (String line : list) {
            for (String word : line.split(" ")) {
                if (word.startsWith("w") || word.startsWith("W")) {
                    fileText.append(word.toLowerCase()
                            .replaceAll("\\W", "")).append(" ");
                }
            }
        }
        String[] result = fileText.toString().split(" ");
        Arrays.sort(result);
        if (fileText.length() == 0) {
            return new String[0];
        }
        return result;
    }
}
