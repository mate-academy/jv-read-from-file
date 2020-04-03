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
    private static final char CONDITION = 'w';
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder inputText = new StringBuilder();
        String inputLine = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                inputLine = br.readLine();
                inputText.append(inputLine.toLowerCase()
                        .replaceAll("\\p{Punct}", ""))
                        .append(WHITESPACE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inputText.length() != 0) {
            StringBuilder words = new StringBuilder();
            for (String word : inputText.toString().split(WHITESPACE)) {
                if (word.charAt(0) == CONDITION) {
                    words.append(word).append(WHITESPACE);
                }
            }
            if (words.length() != 0) {
                String[] result = words.toString().split(WHITESPACE);
                Arrays.sort(result);
                return result;
            }
        }
        return new String[0];
    }
}
