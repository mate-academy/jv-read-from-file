package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<String>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line = "";
            while (line != null) {
                line = file.readLine();
                String[] splittedLine = line.split("\\W+");
                for (String word : splittedLine) {
                    if (word.toLowerCase().startsWith("w")) {
                        words.add(word.toLowerCase());
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        words.sort(Comparator.naturalOrder());
        return (String[]) words.toArray();
    }
}
