package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static final char LETTER = 'w';

    public static String[] readFromFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(fileReader);

            String text = "";
            while (scanner.hasNextLine()) {
                text += scanner.nextLine() + " ";
            }
            String[] words = text.split(" ");
            String resultString = "";

            int index = 0;
            for (int i = 0; i < words.length; i++) {
                if (words.length > 1) {
                    if (words[i].toLowerCase().charAt(0) == LETTER) {
                        resultString += words[i].toLowerCase().replaceAll("[.), \\-'!?]", "") + " ";
                    }
                } else {
                    return new String[0];
                }
            }
            String[] result = resultString.trim().split(" ");
            Arrays.sort(result);

            return result[0] != "" ? result : new String[0];
        } catch (FileNotFoundException e) {
            System.out.println("File with name " + fileName + " not found!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
