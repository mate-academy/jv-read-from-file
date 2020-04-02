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
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> answerList = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX);
        if (allLines != null) {
            for (String s : allLines) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    answerList.add(s.substring(matcher.start(), matcher.end()).toLowerCase());
                }
            }
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
