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

    private static final String START_LETTER = "w";


    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = stringBuilder
                .toString()
                .toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .split(" ");
        Arrays.sort(result);
        return Arrays.stream(result)
                .filter(s -> s.startsWith(START_LETTER))
                .toArray(String[]::new);
    }
}
