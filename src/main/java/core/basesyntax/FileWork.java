package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        String[] words = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }

            words = stringBuilder.toString().toLowerCase().split("[\\s,!.?]+");
            for (int i = 0; i < words.length; i++) {
                if (startWithLetter(words[i])) {
                    count++;
                }
            }
            result = new String[count];
            int c = 0;
            for (int i = 0; i < words.length; i++) {
                if (startWithLetter(words[i])) {
                    result[c] = words[i];
                    c++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File was not found", e);
        } catch (IOException e) {
            throw new RuntimeException("We could not open file", e);
        }
        Arrays.sort(result);
        return result;
    }
}
