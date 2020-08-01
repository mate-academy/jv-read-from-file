package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public String[] readFromFile(String fileName) {
        Path pathToFile = Paths.get(fileName);
        List<String> stringsFromFile = new ArrayList<>();
        if (Files.exists(pathToFile) & Files.isReadable(pathToFile)) {
            try {
                Files.lines(pathToFile)
                        .map(x -> Arrays.stream(x.split("\\W"))
                                .map(String::toLowerCase)
                                .filter(z -> {
                                    if (z.startsWith("w")) {
                                        stringsFromFile.add(z);
                                        return true;
                                    }
                                    return false;
                                }).toArray(String[]::new)).count();
                return arrayCreator(stringsFromFile);
            } catch (IOException e) {
                throw new RuntimeException("Exception when reading a file !!!");
            }
        }
        return new String[0];
    }

    private String[] arrayCreator(List<String> list) {
        String[] stringStartWithW = new String[list.size()];
        list.toArray(stringStartWithW);
        Arrays.sort(stringStartWithW);
        return stringStartWithW;
    }
}
