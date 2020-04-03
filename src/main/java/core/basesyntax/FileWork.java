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
    private static final String START_LETTER = "w";
    
    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] bufferArray = readLine.split(" ");
                for (String line : bufferArray) {
                    if (line.toLowerCase().startsWith(START_LETTER)) {
                        result.append(line.toLowerCase().replaceAll("\\W", "")
                                + " ");
                    }
                }
            }
            String[] resultArray = result.toString().split(" ");
            if (resultArray.length == 1 && resultArray[0].equals("")) {
                return new String[0];
            }
            Arrays.sort(resultArray);
            reader.close();
            return resultArray;
        } catch (IOException e) {
            e.getStackTrace();
        return new String[]{};
    }
}
