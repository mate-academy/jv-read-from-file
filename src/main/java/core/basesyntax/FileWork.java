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
            BufferedReader reader = new BufferedReader(fileReader);
            String readedLine;
            while ((readedLine = reader.readLine()) != null) {
                String[] convertedLine = readedLine.toLowerCase().replaceAll("[^a-zA-Z,\" \"]+", "")
                        .split(" ");
                for (String word : convertedLine) {
                    if (word.startsWith("w")) {
                        line.add(word);
                    }
                }
            }
            if (line.isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(line);
        return line.toArray(new String[line.size()]);
    }
}
