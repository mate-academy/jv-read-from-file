package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {

    private static final String REGEX_W = "\\bw\\w*\\b";

    public String[] readFromFile(String fileName) throws RuntimeException {

        if (fileName == null) {
            throw new RuntimeException("No file with such name was found");
        }

        ArrayList<String> listOfWords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Pattern patternRegexW = Pattern.compile(REGEX_W);
                Matcher lineToLowerCase = patternRegexW.matcher(line.toLowerCase());
                while (lineToLowerCase.find()) {
                    listOfWords.add(lineToLowerCase.group().toLowerCase());
                }
            }
            Collections.sort(listOfWords);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }

        return listOfWords.toArray(new String[0]);
    }
}
