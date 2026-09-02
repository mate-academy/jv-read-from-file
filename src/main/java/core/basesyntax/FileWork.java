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
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] words = stringBuilder.toString().split("[\\p{Punct}\\s]+");
            for (String word : words) {
                if (word.toLowerCase().length() > 1 && word.toLowerCase().charAt(0) == ('w')) {
                    result.add(word.toLowerCase());
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String [] finalResult = result.toArray(new String[0]);
        Arrays.sort(finalResult);
        return finalResult;
    }
}
