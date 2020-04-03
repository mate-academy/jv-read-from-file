package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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

        StringBuilder line = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            line.append(bufferedReader.readLine());
            while (bufferedReader.ready()) {
                line.append(" " + bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] splitWords = line
                .toString()
                .toLowerCase()
                .replaceAll("[^a-zA-Z ]", "")
                .split(" ");

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
        Arrays.sort(finishArray);
        return finishArray;
    }
}
