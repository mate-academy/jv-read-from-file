package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsArray = new ArrayList<>();
        StringBuilder sb = new StringBuilder(" ");
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        String line = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lineArray = sb.toString().toLowerCase().replaceAll("[^a-z]", " ").split(" ");
        for (String i : lineArray) {
            i.split(" ");
            for (int j = 0; j < i.split(" ").length; j++) {
                if (i.split(" ")[j].startsWith("w")) {
                    wordsArray.add(i.split(" ")[j]);
                }
            }
        }
        Collections.sort(wordsArray);
        String[] textFromFile = new String[wordsArray.size()];
        return (String[]) wordsArray.toArray(textFromFile);
    }
}

