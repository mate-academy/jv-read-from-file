package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    private static final char TARGET_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splited = line.split("[\\s,.!?;:\"()\\[\\]{}<>-]+");

                for (String word : splited) {
                    if (!word.isEmpty() && Character.toLowerCase(word.charAt(0)) == TARGET_LETTER) {
                        words.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        words.sort(String::compareTo);
        return words.toArray(new String[0]);
    }
}
