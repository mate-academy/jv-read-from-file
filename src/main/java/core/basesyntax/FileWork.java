package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> wordsStartsWithW = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split("\\W+");
                for (String word : splitLine) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        wordsStartsWithW.add(word.toLowerCase());
                    }
                }
                
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        wordsStartsWithW = wordsStartsWithW.stream().sorted().toList();
        return wordsStartsWithW.toArray(new String[0]);
    }
}
