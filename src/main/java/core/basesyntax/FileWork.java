package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    private static final char SEARCHLETTER = 'w';

    public static String[] readFromFile(String fileName) {
        String sampleLine;
        File sampleFile = new File(fileName);
        ArrayList<String> answerList = new ArrayList<>();
        try (BufferedReader sampleBuffer = new BufferedReader(new FileReader(sampleFile))) {
            while ((sampleLine = sampleBuffer.readLine()) != null) {
                String[] words = sampleLine.split(" ");
                for (String word : words) {
                    if (word.toLowerCase().charAt(0) == SEARCHLETTER) {
                        answerList.add(word.toLowerCase().replaceAll("\\W+",""));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File read error " + e);
        }
        Collections.sort(answerList);
        return answerList.toArray(new String[answerList.size()]);
    }
}
