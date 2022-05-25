package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    private static final String SEARCH_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split(" ");
                for (String word : words) {
                    if (word.startsWith(SEARCH_W)) {
                        builder.append(word).append(" ");
                    }
                }
            }
        }  catch (IOException e) {
            throw new RuntimeException("Can not read the files:" + fileName);
        }
        String clearWord = builder.toString().replaceAll("[!-?-,]", "");
        String[] result = clearWord.split(" ");
        Arrays.sort(result);
        return builder.length() != 0 ? result : new String[]{};
    }
}
