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
        StringBuilder wordsFromFile = new StringBuilder();
        Path filePath = Paths.get(fileName);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String text : lines) {
            for (String soloText : text.split(" ")) {
                if (soloText.startsWith("w") || soloText.startsWith("W")) {
                    wordsFromFile.append(soloText.toLowerCase()
                            .replaceAll("[^a-z]", "")).append(" ");
                }
            }
        }

        String[] result = wordsFromFile.toString().split(" ");
        Arrays.sort(result);

        return wordsFromFile.length() == 0 ? new String[0] : result;
    }
}
