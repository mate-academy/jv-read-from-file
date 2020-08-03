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
    public static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file",e);
        }
        List<String> answerInLine = new ArrayList<>();
        for (String line : fileLines) {
            for (String word : line.split(" ")) {
                if (word.toLowerCase().startsWith(LETTER)) {
                    answerInLine.add(word.toLowerCase().replaceAll("[^\\w]", ""));
                }
            }
        }
        String[] answer = answerInLine.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}
