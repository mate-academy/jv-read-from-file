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
    private static final char FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<String> content = lines.collect(Collectors.toList());
            Pattern p = Pattern.compile("(?i)\\b(" + FIRST_LETTER + "\\w*)\\b");
            Matcher m = p.matcher(content.toString());
            List<String> list = new ArrayList<>();

            while (m.find()) {
                list.add(m.group().toLowerCase());
            }
            String[] arr = new String[list.size()];
            list.toArray(arr);
            Arrays.sort(arr);
            return arr;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
