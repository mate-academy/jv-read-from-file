package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private static final String REGEX = "\\b[wW]\\w*\\b";

    public String[] readFromFile(String fileName) {
        Path file = Paths.get(fileName);
        List<String> allLines;
        try {
            allLines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException("No such file found!");
        }

        List<String> answerList = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX);
        for (String s : allLines) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                answerList.add(s.substring(matcher.start(), matcher.end()).toLowerCase());
            }
        }

        String[] answer = new String[answerList.size()];
        Arrays.sort(answerList.toArray(answer));
        return answer;
    }
}
