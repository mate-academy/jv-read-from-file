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

    static final char CONSTATNT_1 = 'w';
    static final char CONSTANT_2 = 'W';

    public String[] readFromFile(String fileName) {
        ArrayList<String> ourWords = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner document = new Scanner(file);

            while (document.hasNextLine()) {
                String[] lineWithWords = document.nextLine().split(" ");
                for (int i = 0; i < lineWithWords.length; i++) {
                    if (lineWithWords[i].startsWith(String.valueOf(CONSTATNT_1))
                            || lineWithWords[i].startsWith(String.valueOf(CONSTANT_2))) {
                        ourWords.add(lineWithWords[i].toLowerCase()
                                .replaceAll("\\w+\\d", "")
                                .replaceAll("[, '!.)?-]", ""));
                    }
                }
            }
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(ourWords);
        String[] arr = ourWords.toArray(new String[ourWords.size()]);
        Arrays.toString(arr);
        return arr;
    }
}
