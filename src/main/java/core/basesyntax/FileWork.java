package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final String SMALL_W = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder wordsStartWithW = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNext()) {
                return new String[0];
            }
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (word.startsWith(SMALL_W)) {
                    wordsStartWithW.append(word.replaceAll("[^a-zA-Z]", "") + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] sortedWords = wordsStartWithW.toString().trim().split(" ");
        Arrays.sort(sortedWords);
        return sortedWords.length > 1 ? sortedWords : new String[0];
    }
}
