package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
            String[] words = fileName.split("\\W+");
            List<String> filteredWords = new ArrayList<>();
            for (String word : words) {
                if (word.startsWith("w")) {
                    filteredWords.add(word);
                }
            }
            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("can`t reach file", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException("can`t reach file", e);
                }
            }
        }
    }
}
