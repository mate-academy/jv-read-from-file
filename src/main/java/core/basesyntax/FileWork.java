package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        ArrayList<String> res = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    String[] tmp = line.split("\\W");
                    for (String word : tmp) {
                        if (word.trim().length() > 0 
                                && word.trim().toLowerCase().charAt(0) == 'w') {
                            res.add(word.trim().toLowerCase());
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return Arrays.copyOf(res.stream().sorted().toArray(), 
                res.size(), String[].class);
    }
}
