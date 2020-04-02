package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private static final char FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        String [] arrayResult = new String[0];
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String myStringBuffer = new String();
            List<String> listResult = new ArrayList<String>();
            while ((myStringBuffer = reader.readLine()) != null) {
                myStringBuffer = myStringBuffer.toLowerCase().replaceAll("[^a-zA-Z\\s]","");
                String[] arrayWords = myStringBuffer.split(" ");
                for (String tempWord: arrayWords) {
                    if (tempWord.indexOf(FIRST_LETTER) == 0) {
                        listResult.add(tempWord);
                    }
                }
                Collections.sort(listResult);
                arrayResult = listResult.toArray(new String[listResult.size()]);
            }
        } catch (IOException e) {
            throw new RuntimeException("There is no such file", e);
        }
        return arrayResult;
    }
}
