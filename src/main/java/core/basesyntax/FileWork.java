package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder data = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.append(line).append(" ");
            }
            if (data.length() == 0) {
                return new String[0];
            }

            String[] dataWords = data.toString().toLowerCase().split("\\W+");
            String[] result = new String[dataWords.length];
            int i = 0;
            for (String word : dataWords) {
                if (word == null || !"w".equals(word.substring(0,1))) {
                    continue;
                }
                result[i] = word;
                i++;
            }
            result = Arrays.copyOfRange(result, 0, i);
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Bad file", e);
        }
    }
}
