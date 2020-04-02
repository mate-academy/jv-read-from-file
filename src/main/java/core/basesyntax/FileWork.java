package core.basesyntax;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            String lines = Files.readString(Paths.get(fileName));
            String[] content = lines.toLowerCase().split(" ");
            StringBuilder words = new StringBuilder();

            for (String word: content) {
                if(word.startsWith(FIRST_LETTER)) {
                    words.append(word.replaceAll("\\W", "")).append(" ");
                    System.out.println(words.toString());
                }
            }
            String[] arr = words.length() > 0 ? words.toString().split(" ") : new String[0];
            Arrays.sort(arr);
            return arr;
        } catch (Exception e) {
            throw new RuntimeException("Hi, i am your headache", e);
        }
    }
}
