package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String LETTER_LOW = "w";
    private static final String LETTER_UPPER = "W";

    public String[] readFromFile(String fileName) {
        int countWords = 0;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String string = reader.readLine();
            while (string != null) {
                builder.append(string).append(" ");
                string = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] array = builder.toString().toLowerCase().split("\\W+");
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith(LETTER_LOW) || array[i].startsWith(LETTER_UPPER)) {
                countWords++;
            }
        }
        String[] result = new String[countWords];
        int index = 0;
        for (String array1 : array) {
            if (array1.startsWith(LETTER_LOW) || array1.startsWith(LETTER_UPPER)) {
                result[index] = array1;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
