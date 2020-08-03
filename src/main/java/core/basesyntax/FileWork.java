package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    static final char CHECK_WITH_W = 'w';

    public String[] readFromFile(String fileName) {
        ArrayList<String> ourWords = new ArrayList<>();
        File file = new File(fileName);
        try (Scanner document = new Scanner(file)) {
            while (document.hasNextLine()) {
                String[] lineWithWords = document.nextLine().split(" ");
                for (int i = 0; i < lineWithWords.length; i++) {
                    if (lineWithWords[i].toLowerCase().startsWith(String.valueOf(CHECK_WITH_W))) {
                        ourWords.add(lineWithWords[i].toLowerCase()
                                .replaceAll("\\w+\\d", "")
                                .replaceAll("[, '!.)?-]", ""));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(ourWords);
        String[] resultWords = ourWords.toArray(new String[ourWords.size()]);
        Arrays.toString(resultWords);
        return resultWords;
    }
}
