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
        String[] wordsStartWithW;
        try {
            String lineFileName = Files.readString(Paths.get(fileName));
            String[] arrayFile = lineFileName.toLowerCase().split(" ");
            StringBuilder BasicLine = new StringBuilder();
            for (String temp : arrayFile) {
                if (temp.toLowerCase().startsWith("w")) {
                    BasicLine.append(temp.replaceAll("\\W", "")).append(" ");
                }
            }
            wordsStartWithW = BasicLine.toString().split(" ");
            Arrays.sort(wordsStartWithW);

            return BasicLine.length() > 0 ? wordsStartWithW : new String[0];
        } catch (IOException e) {
            throw new RuntimeException("No such file", e);
        }

    }
}
