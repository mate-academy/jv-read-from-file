package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWork {
    private static final Logger LOGGER = Logger.getLogger(FileWork.class.getName());

    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\W+");
                for (String token : tokens) {
                    if (token.toLowerCase().startsWith("w")) {
                        words.add(token.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read from file: " + fileName, e);
        }
        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}


