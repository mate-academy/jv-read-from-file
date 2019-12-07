package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
        String resultLine = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while (reader.ready()) {
                resultLine += reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        resultLine = resultLine.replaceAll("[^(\\sa-zA-Z)]", "");
        String[] words = resultLine.split(" ");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                list.add(word.toLowerCase());
            }
        }
        if (list.isEmpty()) {
            return new String[0];
        }
        Collections.sort(list);
        String[] arrayResult = new String[list.size()];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = list.get(i);
        }
        return arrayResult;
    }
}
