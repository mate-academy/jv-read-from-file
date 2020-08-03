package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String WORD_STARTS_WITH = "w";

    public String[] readFromFile(String fileName) {
        Path inputFilePath = Paths.get(fileName);
        List<String> inputFile = new ArrayList<>();
        try {
            inputFile = Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
        ArrayList<String> result = new ArrayList<>();
        for (String string : inputFile) {
            String[] words = string.split(" ");

            for (String word : words) {
                String resultWord = word.toLowerCase().replaceAll("\\W", "");
                if (resultWord.startsWith(WORD_STARTS_WITH)) {
                    result.add(resultWord);
                }
            }
        }
        Collections.sort(result);
        return result.toArray((new String[result.size()]));
    }
}
