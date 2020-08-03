package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<String> resultWords = new ArrayList<>();
        List<String> inputLines = null;
        try {
            inputLines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String string : inputLines) {
            for (String oneWord : string.toLowerCase().split("[^a-z]+")) {
                if (oneWord.charAt(0) == FIRST_LETTER) {
                    resultWords.add(oneWord);
                }
            }
        }
        Collections.sort(resultWords);
        return resultWords.toArray(new String[]{});
    }
}
