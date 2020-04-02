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
    public static final String CONSTANT = "w";

    public String[] readFromFile(String fileName) {
        String[] result;
        StringBuilder needWord = new StringBuilder();
        try {
            String text = Files.readString(Paths.get(fileName));
            String[] wordsArr = text.toLowerCase().split(" ");
            for (String word : wordsArr) {
                if (word.startsWith(CONSTANT)) {
                    needWord.append(word.replaceAll("\\W","")).append(" ");
                }
            }
            result = needWord.toString().split(" ");
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return needWord.length() > 0 ? result : new String[0];
    }
}
