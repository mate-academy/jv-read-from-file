package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (word.startsWith("w")) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                line = reader.readLine();
            }
            String[] rez = {};
            if (!stringBuilder.toString().equals("")) {
                rez = stringBuilder.toString().split(" ");
            }
            Arrays.sort(rez);
            return rez;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
