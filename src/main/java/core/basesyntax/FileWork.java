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
    public static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String[] result;
        try {
            String text = Files.readString(Paths.get(fileName));
            String[] words = text.toLowerCase().split(" ");
            StringBuilder correctWords = new StringBuilder();
            for (String word : words) {
                if (word.startsWith(START_LETTER)) {
                    correctWords.append(word.replaceAll("\\W","")).append(" ");
                }
            }
            result = correctWords.length() > 0 ? correctWords.toString().split(" ") : new String[0];
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Такого файла не существует", e);
        }
        return result;
    }
}
