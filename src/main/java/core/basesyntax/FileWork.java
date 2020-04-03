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
    public String[] readFromFile(String fileName) {
        String[] result;
        try {
            String line = Files.readString(Paths.get(fileName));
            String[] lineList = line.toLowerCase().split(" ");
            StringBuilder wordWList = new StringBuilder();
            for (String word: lineList) {
                if (word.toLowerCase().startsWith("w")) {
                    wordWList.append(word.replaceAll("\\W","")).append(" ");
                }
            }
            result = wordWList.toString().split(" ");
            Arrays.sort(result);
            return wordWList.length() > 0 ? result : new String[0];
        } catch (IOException e) {
            throw new RuntimeException("No such file", e);
        }
    }
}
