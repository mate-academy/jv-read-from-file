package core.basesyntax;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        FileReader fr = null;
        ArrayList<String> readFrom = new ArrayList<String>();
        try {
            fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String str = null;
            while ((str = bf.readLine()) != null) {
                String[] arrayWords = str.toLowerCase().replaceAll("[.,?!]", "").split("\\s");
                for (String s : arrayWords) {
                    if (s.toLowerCase().startsWith("w")) {
                        readFrom.add(s);
                    }
                }
            }
            fr.close();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readFrom.sort(Comparator.naturalOrder());
        String[] readFromFile = readFrom.toArray(new String[0]);
        return readFromFile;

    }
}
