package core.basesyntax;

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

    public static final String SORT_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String[] resultString;
        try {
            String text = Files.readString(Paths.get(fileName));
            String[] words = text.toLowerCase().split(" ");
            StringBuilder correctWords = new StringBuilder();
            for (String word : words) {
                if (word.startsWith(SORT_LETTER)) {
                    correctWords.append(word.replaceAll("\\W","")).append(" ");
                }
            }
            resultString = correctWords.toString().split(" ");
            Arrays.sort(resultString);
        } catch (IOException e) {
            throw new RuntimeException("File doesn't exist", e);
        }
        return resultString;
    }
}
