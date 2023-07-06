package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char KEY_CHAR_TO_FIND = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        File textFile = new File(fileName);
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(textFile));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.charAt(0) == KEY_CHAR_TO_FIND) {
                        result.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open a file!", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file!", e);
        }
        String[] foundWords = result.stream().toArray(String[]::new);
        Arrays.sort(foundWords);
        return foundWords;
    }
}
