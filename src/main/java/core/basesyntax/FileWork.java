package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private ArrayList<String> wordsWithW = new ArrayList<>();
    private String line;

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\W+");
                for (String word : split) {
                    if (word.toLowerCase().startsWith("w")) {
                        wordsWithW.add(word.toLowerCase());
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(wordsWithW);
        return wordsWithW.toArray(new String[0]);
    }
}
