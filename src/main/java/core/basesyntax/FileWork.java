package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */

public class FileWork {

    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) throws RuntimeException {
        File file = new File(fileName);
        ArrayList<String> textStartsWithW = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.toLowerCase().split(" ");
                for (String word : lineArray) {
                    if (word.startsWith(LETTER)) {
                        textStartsWithW.add(word.replaceAll("\\W+", ""));
                    }
                }
            }
            Collections.sort(textStartsWithW);
            return textStartsWithW.toArray(new String[textStartsWithW.size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

