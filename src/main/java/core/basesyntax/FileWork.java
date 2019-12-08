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
    public String[] readFromFile(String fileName) {
        String[] wordsWithSym = {};
        String text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readline = "";
            while ((readline = reader.readLine()) != null) {
                text += readline;
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        wordsWithSym = getWordsBeginningWhithSym(text, 'w');
        Arrays.sort(wordsWithSym);
        return wordsWithSym;
    }

    public String[] getWordsBeginningWhithSym(String line, char sym) {
        String[] result = {};
        if (line.length() != 0) {
            result = Arrays.stream(line.split(" "))
                    .map(word -> word.toLowerCase()).map(word -> word.replaceAll("[^a-z]", ""))
                    .filter(word -> word.charAt(0) == sym)
                    .toArray(String[]::new);
        }
        return result;
    }
}
