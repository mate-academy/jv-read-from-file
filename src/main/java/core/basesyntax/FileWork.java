package core.basesyntax;

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
    public static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) throws RuntimeException {
        String[] result;
        try {
            StringBuilder wordsFromFile = new StringBuilder();
            Path filePath = Paths.get(fileName);
            List<String> lines = Files.readAllLines(filePath);

            for (String text : lines) {
                for (String soloText : text.split(" ")) {
                    if (soloText.toLowerCase().startsWith(START_LETTER)) {
                        wordsFromFile.append(soloText.toLowerCase()
                                .replaceAll("[^a-z]", "")).append(" ");
                    }
                }
            }

            result = wordsFromFile.length() > 0
                    ? wordsFromFile.toString().split(" ") : new String[0];
            Arrays.sort(result);

        } catch (Exception e) {
            throw new RuntimeException("Такого файла не существует", e);
        }

        return result;
    }
}
