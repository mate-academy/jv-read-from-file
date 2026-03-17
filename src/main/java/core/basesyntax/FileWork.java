package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stb = new StringBuilder();
        int countOfWords = 0;
        String target = "w";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stb.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] words = stb.toString().toLowerCase().split("\\W+");

        for (String word : words) {
            if (word.charAt(0) == target.charAt(0)) {
                countOfWords++;
            }
        }

        String[] result = new String[countOfWords];

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == target.charAt(0)) {
                result[count] = words[i];
                count++;
            }
        }
        Arrays.sort(result);

        return result;
    }
}
