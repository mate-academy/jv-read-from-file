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
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = new String[(int) file.length()];
        int counter = 0;

        try (FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] lineWords = fileLine.replaceAll("[^\\w]", " ").split(" ");
                for (String word : lineWords) {
                    word = word.toLowerCase();
                    if (word.startsWith("w")) {
                        result[counter] = word;
                        counter++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = Arrays.copyOf(result, counter);
        Arrays.sort(result);

        return result;
    }

}

