package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder filteredWords = new StringBuilder();
        File file = new File(fileName);
        if (file.length() <= 0) {
            return new String[]{};
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("\\W+", "");
                    if (word.startsWith("w")) {
                        filteredWords.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] res = filteredWords.toString().split(" ");
        if (res[0].equals("")) {
            return new String[]{};
        }
        Arrays.sort(res);
        return res;
    }
}
