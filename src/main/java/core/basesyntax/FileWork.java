package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if (Files.exists(pathToFile) & Files.isReadable(pathToFile)) {
            try {
                List<String[]> collect = Files.lines(pathToFile)
                        .map(x -> Arrays.stream(x.split(" "))
                        .map(z -> z.toLowerCase())
                        .filter(z -> z.startsWith("w"))
                        .toArray(String[]::new))
                        .collect(Collectors.toList());
                return arrayCreator(collect);
            } catch (IOException e) {
                throw new RuntimeException("Exception when reading a file !!!");
            }
        }
        return new String[0];
    }

    private static int findSize(List<String[]> list) {
        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            size += list.get(i).length;
        }
        return size;
    }

    private static String[] arrayCreator(List<String[]> list) {
        String[] stringStartWithW = new String[findSize(list)];
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                stringStartWithW[count] = list.get(i)[j].replaceAll("\\W", "");
                count++;
            }
        }
        Arrays.sort(stringStartWithW);
        return stringStartWithW;
    }
}
