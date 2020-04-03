package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public static final String FIRST_WORD = "w";

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }

        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            line = bufferedReader.readLine();
            while (bufferedReader.ready()) {
                line += " " + bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        line = line.toLowerCase().replaceAll("[^a-zA-Z ]", "");

        String[] splitWords = line.split(" ");
        String rightWords = "";
        for (int i = 0; i < splitWords.length; i++) {
            if (splitWords[i].startsWith(FIRST_WORD)) {
                rightWords = rightWords.concat(splitWords[i] + " ");
            }
        }

        if (rightWords.length() == 0) {
            return new String[0];
        }

        String[] finishArray = rightWords.split(" ");

        for (int i = 0; i < finishArray.length - 1; i++) {
            for (int j = i + 1; j < finishArray.length; j++) {
                if (finishArray[i].compareTo(finishArray[j]) > 0) {
                    String temp = finishArray[i];
                    finishArray[i] = finishArray[j];
                    finishArray[j] = temp;
                }
            }
        }
        return finishArray;
    }
}
