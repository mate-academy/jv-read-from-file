package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> sentences;
        try {
            sentences = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        List<String> resultList = new ArrayList<>();
        for (String sentence : sentences) {
            String[] splittedSentence = sentence.toLowerCase().split(" ");
            for (String word : splittedSentence) {
                if (word.startsWith(FIRST_LETTER)) {
                    resultList.add(word.replaceAll("\\W", ""));
                }
            }
        }

        String[] solution = resultList.toArray(new String[resultList.size()]);
        Arrays.sort(solution);
        return solution;
    }
}
