package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    private static final String SEARCH_WORD = "\\b[w]\\w*\\b";

    public static String[] readFromFile(String fileName) {
        List<String> wordList = new ArrayList<>();
        Pattern pattern = Pattern.compile(SEARCH_WORD);
        Matcher matcher;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line.toLowerCase());
                while (matcher.find()) {
                    wordList.add(matcher.group());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found!");
        }

        String[] words = wordList.toArray(new String[0]);
        Arrays.sort(words);

        return words;
    }
}
