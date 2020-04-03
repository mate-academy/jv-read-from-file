package core.basesyntax;

import java.io.BufferedReader;
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

    public final char charW = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder wordsStartW = new StringBuilder();
        if (text.length() > 0) {
            String[] words = text.toString().toLowerCase().split(" ");
            for (String word : words) {
                if (word.charAt(0) == charW) {
                    wordsStartW.append(word.replaceAll("\\W", "")).append(' ');
                }
            }
        }
        String[] result = new String[0];
        if (wordsStartW.length() > 0) {
            result = wordsStartW.toString().split(" ");
            Arrays.sort(result);
        }
        return result;
    }
}
