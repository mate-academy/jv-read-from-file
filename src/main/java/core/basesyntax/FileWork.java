package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final int START_INDEX = 1;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("\\W+");
                line = reader.readLine();
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.charAt(0) == 'w') {
                        resultList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file!", e);
        }
        String[] result = resultList.toArray(new String[0]);
        sort(result);
        return result;
    }

    public void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (isAfter(array[i], array[j])) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public boolean isAfter(String word1, String word2) {
        if (word1.equals(word2)) {
            return false;
        }
        int length = Math.min(word1.length(), word2.length());
        for (int i = START_INDEX; i < length; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                continue;
            } else {
                return word1.charAt(i) > word2.charAt(i);
            }
        }
        return false;
    }
}
