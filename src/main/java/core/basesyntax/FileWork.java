package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final int ZERO = 0;
    private List<String> wordList = new ArrayList<>();

    public String[] readFromFile(String file) {
        File myFile = new File(file);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] split = value.split("\\W+");
                for (String word : split) {
                    if (!word.isEmpty() && (word.charAt(ZERO) == 'w' || word.charAt(ZERO) == 'W')) {
                        wordList.add(word.toLowerCase());
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] array = wordList.toArray(new String[ZERO]);
        if (array.length != ZERO) {
            Arrays.sort(array);
        }
        return (array);
    }
}

