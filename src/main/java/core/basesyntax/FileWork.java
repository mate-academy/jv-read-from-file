package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {

    public String[] readFromFile(String fileName) {


        String[] arrayWordFromFile = new String[5];
        int i = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String filterWord
                            = word.replaceAll("[\\p{Punct}]", "").toLowerCase(Locale.ROOT);
                    if (filterWord.startsWith("w")) {
                        arrayWordFromFile[i] = filterWord;
                        i++;
                    } else if (fileName == null) {
                        return null;
                    }
                }
            }
            Arrays.sort(arrayWordFromFile);
            return arrayWordFromFile;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

