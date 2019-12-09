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
        String readfromFile = "";
        final String leterW = "w";
        try {
            readfromFile = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }
        String[] separatewords = readfromFile.toLowerCase().replaceAll("[^A-Za-z]", " ")
                .split(" ");
        List<String> filteredWords = new ArrayList<>();
        for (String words : separatewords) {
            if (words.startsWith(leterW)) {
                filteredWords.add(words);
            }
        }
        Collections.sort(filteredWords);
        return filteredWords.toArray(new String[filteredWords.size()]);
    }
}
