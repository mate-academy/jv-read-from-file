package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
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
        StringBuilder stringBuilder = new StringBuilder();

        try {
            List<String> stringsList = Files.readAllLines(Paths.get(fileName));

            if (stringsList.isEmpty()) {
                return new String[0];
            }

            for (String string : stringsList) {
                String[] words = string.toLowerCase().split(" ");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        stringBuilder.append(word.replaceAll("[^a-z]+", "")).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }

        String[] resultArray = stringBuilder.toString().trim().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
