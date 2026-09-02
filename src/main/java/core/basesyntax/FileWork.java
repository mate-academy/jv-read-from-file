package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWork {
    private static final Logger LOGGER = Logger.getLogger(FileWork.class.getName());

    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.toLowerCase().split("\\W+");

                for (String word : lineWords) {
                    if (word.startsWith("w")) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file: " + fileName, e);
        }

        String[] result = words.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
