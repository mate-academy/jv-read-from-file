package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wlines = new ArrayList<>();
        List<String> splittedFile = new ArrayList<>();
        try (BufferedReader file
                    = new BufferedReader(new FileReader(fileName));) {

            String line;

            while ((line = file.readLine()) != null) {
                String[] words = line.toLowerCase().split("[ ,.!?]+");
                for (String word: words) {
                    splittedFile.add(word);
                }
            }
            for (String record : splittedFile) {
                if (record.startsWith("w")) {
                    wlines.add(record);
                    wlines.sort(null);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return wlines.toArray(new String[0]);
    }
}
