package core.basesyntax;

import java.io.BufferedReader;
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
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {

        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String[] result = new String[fileReader.toString().length()];
            int counter = 0;
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] lineWords = fileLine.replaceAll("[^\\w]", " ").split(" ");
                for (String word : lineWords) {
                    word = word.toLowerCase();
                    if (word.startsWith(FIRST_LETTER)) {
                        result[counter] = word;
                        counter++;
                    }
                }
            }
            result = Arrays.copyOf(result, counter);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{""};
    }

}

