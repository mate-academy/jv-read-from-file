package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> startsWithW = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] splittedLine = line.split(" ");
                for (String splittedLines : splittedLine) {
                    splittedLines = splittedLines.toLowerCase();
                    if (splittedLines.startsWith("w")) {
                        splittedLines = splittedLines.replaceAll("[^a-zA-Z0-9\\s]", "");
                        startsWithW.add(splittedLines);
                    }
                }
                line = reader.readLine();
            }
            Collections.sort(startsWithW);
            return startsWithW.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + fileName + " not found", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
