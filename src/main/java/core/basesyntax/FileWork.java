package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = new String[countWWords(new File(fileName))];
        return getWordsArray(new File(fileName), result);
    }

    private int countWWords(File file) {
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                if ((char) value == 'w' || (char) value == 'W') {
                    count++;
                }
                while (Character.isAlphabetic((char) value)) {
                    value = bufferedReader.read();
                }
                value = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return count;
    }

    private String[] getWordsArray(File file, String[] strings) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            int value = bufferedReader.read();
            int count = 0;
            while (value != -1) {
                if ((char) value == 'w' || (char) value == 'W') {
                    while (Character.isAlphabetic((char) value)) {
                        builder.append((char) value);
                        value = bufferedReader.read();
                    }
                    strings[count] = builder.toString().toLowerCase(Locale.ROOT);
                    count++;
                    builder = new StringBuilder();
                } else {
                    while (Character.isAlphabetic((char) value)) {
                        value = bufferedReader.read();
                    }
                }
                value = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        Arrays.sort(strings);
        return strings;
    }
}
