package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int counter = 0;
        File file = new File(fileName);
        String [] out;

        try {
            String array = Files.readAllLines(file.toPath()).toString();
            String [] strings = array.split("\\W+");

            for (int i = 0; i < strings.length; i++) {
                if (strings[i].isEmpty()) {
                    continue;
                }
                if (strings[i].charAt(0) == 'w' || strings[i].charAt(0) == 'W') {
                    counter++;
                }
            }
            if (counter == 0) {
                return new String[0];
            } else {
                out = new String[counter];
                for (int i = 0, j = 0; i < strings.length; i++) {
                    if (strings[i].isEmpty()) {
                        continue;
                    }
                    if (strings[i].charAt(0) == 'w' || strings[i].charAt(0) == 'W') {
                        out[j] = strings[i].toLowerCase();
                        j++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Sort by alphabet
        Arrays.sort(out);
        return out;
    }
}
