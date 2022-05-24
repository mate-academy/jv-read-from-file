package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] words = value.toLowerCase().split(" ");
                for (String word : words) {
                    if (word.startsWith(CHARACTER)) {
                        builder.append(word).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't found the file: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + fileName);
        }
        String clearWord = builder.toString().replaceAll("\\pP","");
        String[] result = clearWord.split(" ");
        Arrays.sort(result);
        return builder.length() != 0 ? result : new String[]{};
    }
}
