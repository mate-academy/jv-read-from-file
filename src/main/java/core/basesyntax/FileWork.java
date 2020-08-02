package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    private static final char LETTER = 'w';

    public String[] readFromFile(String fileName) throws RuntimeException {

        File file = new File(fileName);
        ArrayList<String> textFromFile = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] text = scanner.nextLine().toLowerCase().split(" ");
                for (String line : text) {
                    if (line.startsWith(String.valueOf(LETTER))) {
                        textFromFile.add(line.replaceAll("[\\W]", ""));
                    }
                }
            }
            String[] result = new String[textFromFile.size()];
            for (int i = 0; i < textFromFile.size(); i++) {
                result[i] = textFromFile.get(i);
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

