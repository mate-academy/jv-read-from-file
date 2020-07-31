package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final char FIRST_CHARACTER_VALUE = 'w';
    private static final int FIRST_CHARACTER = 0;

    public String[] readFromFile(String fileName) {
        List<String> resultList = new ArrayList<>();
        List<String> strings = null;

        try {
            strings = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println("There are no such file.");
        }
        for (String string : strings) {
            String[] wordArray = string.split(" ");
            for (String word : wordArray) {
                if (word.toLowerCase().charAt(FIRST_CHARACTER) == FIRST_CHARACTER_VALUE) {
                    resultList.add(word.toLowerCase().replaceAll("[\\W+]", ""));
                }
            }
        }
        if (resultList.size() == 0) {
            return new String[]{};
        }
        resultList.sort(Comparator.naturalOrder());
        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
