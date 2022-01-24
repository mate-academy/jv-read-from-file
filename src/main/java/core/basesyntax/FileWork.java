package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String row = bufferedReader.readLine();
            while (row != null) {
                String[] words = row.split("\\W+");
                for (String word : words) {
                    if (Character.toLowerCase(word.charAt(0)) == 'w') {
                        builder.append(word);
                        builder.append(" ");
                    }
                }
                row = bufferedReader.readLine();
            }
            if (builder.toString().length() == 0) {
                return new String[0];
            }
            String[] strings = builder.toString().toLowerCase(Locale.ROOT).split(" ");
            Arrays.sort(strings);
            return strings;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
