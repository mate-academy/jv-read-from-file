package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        ArrayList<String> wordsWithLetterW = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] allWordsInLine = line.split("\\W+");
                for (String wordInLine : allWordsInLine) {
                    if (wordInLine.toLowerCase().charAt(0) == 'w') {
                        wordsWithLetterW.add(wordInLine.toLowerCase());
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("file read", e);
        }
        String[] result = new String[wordsWithLetterW.size()];
        result = wordsWithLetterW.toArray(result);
        Arrays.sort(result);
        return result;
    }
}
