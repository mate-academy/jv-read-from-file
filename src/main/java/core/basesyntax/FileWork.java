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

    public static final char WORD_START_AT = 'w';
    public static final String ALL_PUNCTUATION = "\\p{Punct}";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line.toLowerCase().replaceAll(ALL_PUNCTUATION, ""));
                stringBuilder.append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        StringBuilder result = new StringBuilder();
        while (stringBuilder.length() != 0) {
            if (stringBuilder.charAt(0) == WORD_START_AT) {
                result.append(stringBuilder.subSequence(0, stringBuilder.indexOf(" "))).append(" ");
            }
            stringBuilder.delete(0, stringBuilder.indexOf(" ") + 1);
        }
        if (result.length() != 0) {
            String[] finalResult = result.toString().split(" ");
            Arrays.sort(finalResult);
            return finalResult;
        }
        return new String[0];
    }
}


