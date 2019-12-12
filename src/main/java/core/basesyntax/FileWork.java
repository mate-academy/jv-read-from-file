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
    public String[] readFromFile(String fileName) {

        List<String> line = new ArrayList<String>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arrayOfWords = str.toLowerCase().replaceAll("[^a-zA-Z,\" \"]+", " ")
                        .split(" ");
                for (int i = 0; i < arrayOfWords.length; i++) {
                    if (arrayOfWords[i].startsWith("w")) {
                        line.add(arrayOfWords[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(line);
        return line.toArray(new String[line.size()]);
    }
}
