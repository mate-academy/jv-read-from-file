package core.basesyntax;

import java.io.BufferedReader;
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
    public static final String W = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsArray = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(" ");
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lineArray = stringBuilder.toString().toLowerCase()
                .replaceAll("[^a-z]", " ").split(" ");
        for (String i : lineArray) {
            for (int j = 0; j < i.split(" ").length; j++) {
                if (i.split(" ")[j].startsWith(W)) {
                    wordsArray.add(i.split(" ")[j]);
                }
            }
        }
        Collections.sort(wordsArray);
        String[] textFromFile = new String[wordsArray.size()];
        return (String[]) wordsArray.toArray(textFromFile);
    }
}
