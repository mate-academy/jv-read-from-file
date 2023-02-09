package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                String anotherLine = line.toLowerCase().replaceAll("\\W+", " ");
                String[] array = anotherLine.split("\\s+");
                for (int i = 0; i < array.length; i++) {
                    if (array[i].startsWith("w")) {
                        builder.append(array[i]).append(' ');
                    }
                }
                line = reader.readLine();
            }
            String[] words = builder.toString().split("\\s");
            Arrays.sort(words);
            return words.length == 1 ? new String[0] : words;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not exist", e);
        } catch (IOException e) {
            throw new RuntimeException("Reading error from file", e);
        }
    }
}