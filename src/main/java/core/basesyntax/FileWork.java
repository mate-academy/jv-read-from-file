package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    static final String FILTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> sortingLine = new ArrayList<String>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readedLine;
            while ((readedLine = bufferedReader.readLine()) != null) {
                String[] convertedLine = readedLine.toLowerCase().replaceAll("[^a-zA-Z,\" \"]+", "")
                        .split(" ");
                for (String word : convertedLine) {
                    if (word.startsWith(FILTER)) {
                        sortingLine.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
        Collections.sort(sortingLine);
        return sortingLine.toArray(new String[sortingLine.size()]);
    }
}
