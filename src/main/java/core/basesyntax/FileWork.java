package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(fileName)));
            List<String> filteredWords = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r\f,.:;?!\"'()-");

            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken().toLowerCase();
                if (word.startsWith("w")) {
                    filteredWords.add(word);
                }
            }

            String[] result = filteredWords.toArray(new String[0]);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
