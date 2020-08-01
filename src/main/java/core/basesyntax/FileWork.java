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
    public String[] readFromFile(String fileName) {
        List<String> resultWords = new ArrayList<>();
        try {
            List<String> inputLines = Files.readAllLines(Paths.get(fileName));
            for (String string : inputLines) {
                for (String oneWord : string.toLowerCase()
                        .replaceAll("[^a-z]", " ")
                        .replaceAll("\\s+", " ")
                        .split(" ")
                ) {
                    if (oneWord.charAt(0) == 'w') {
                        resultWords.add(oneWord);
                    }
                }
            }
        } catch (IOException e) {
            return new String[]{};
        }
        Collections.sort(resultWords);
        return resultWords.toArray(new String[]{});
    }
}
