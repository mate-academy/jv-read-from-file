package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
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

    public static final char CONSTW = 'w';

    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsWithWList = new ArrayList<String>();
        String text = "";
        try {
            text = new String(Files.readAllBytes((Paths.get(fileName)))).toLowerCase().replaceAll(
                    "[^A-Za-zА-Яа-я\n ]", "");
        } catch (IOException e) {
            throw new RuntimeException("Такого файла не существует", e);
        }
        if (text.length() == 0) {
            return new String[0];
        }
        for (String line : text.split("\n")) {
            for (String word : line.split(" ")) {
                if (word.charAt(0) == CONSTW) {
                    wordsWithWList.add(word);
                }
            }
        }
        String[] wordsWithWArray = wordsWithWList.toArray(String[]::new);
        Arrays.sort(wordsWithWArray);
        return wordsWithWArray;
    }
}
