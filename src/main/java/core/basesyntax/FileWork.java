package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        String[] result;
        try {
            String line = Files.readString(Paths.get(fileName));
            String[] lineList = line.toLowerCase().split(" ");
            StringBuilder wList = new StringBuilder();
            for (String word: lineList) {
                if (word.toLowerCase().startsWith("w")) {
                    wList.append(word.replaceAll("[^a-zA-Z0-9]","")).append(" "); // please help i have problem with mvn
                } //  ileWork.java:21:27: Local variable name 'wList' must match pattern '^[a-z]([a-z0-9][a-zA-Z0-9]*)?$'. [LocalVariableName]
            }
            if (wList.length() > 0) {
                result = wList.toString().split(" ");
            } else {
                result = new String[0];
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("No such file");
        }
    }
}
