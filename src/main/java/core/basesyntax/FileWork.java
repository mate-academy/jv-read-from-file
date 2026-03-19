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

    public static final char LETTER_CONDITION = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> resultList = new ArrayList<>();// correct

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.toLowerCase().split("[\\s\\p{Punct}]+");
                for (String part: parts) {
                    if (!part.isEmpty() && part.charAt(0) == LETTER_CONDITION) {
                        resultList.add(part);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String[] resultArray = resultList.toArray(new String[0]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
