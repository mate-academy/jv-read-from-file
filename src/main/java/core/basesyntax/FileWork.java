package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public static final String SEARCH_LETTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> resultList = new ArrayList<String>();
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException("We cant read a file",e);
        }
        for (String wordFromFile : list) {
            wordFromFile = wordFromFile.toLowerCase();
            String[] stringArray = wordFromFile.split("\\W");
            for (String needleWords : stringArray) {
                if (needleWords.startsWith(SEARCH_LETTER)) {
                    resultList.add(needleWords);
                }
            }
        }
        String[] result = resultList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
