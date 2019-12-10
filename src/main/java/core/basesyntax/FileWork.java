package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
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

    private static final String START_OF_WORDS = "w";
    private static final String REGEX_NON_WORDS = "[^a-z+]";

    public String[] readFromFile(String fileName) {
        List<String> correctWordsList = new ArrayList<>();
        try {
            List<String> array = Files.readAllLines(Paths.get(fileName));
            for (String value : array) {
                String[] tmp = value.toLowerCase().split(" ");
                for (String s : tmp) {
                    if (s.startsWith(START_OF_WORDS)) {
                        correctWordsList.add(s.replaceAll(REGEX_NON_WORDS, ""));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to upload file, make sure it's exist");
        }
        String[] newArr = correctWordsList.toArray(new String[0]);
        Arrays.sort(newArr);
        return newArr;
    }
}
