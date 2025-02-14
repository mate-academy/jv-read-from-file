package core.basesyntax;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] ArrayWordFromFile = new String[5];
        int i = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String filterWord = word.replaceAll("[\\p{Punct}]", "").toLowerCase(Locale.ROOT);
                    if (filterWord.startsWith("w")) {
                        ArrayWordFromFile[i] = filterWord;
                        i++;
                    }
                }
            }
            Arrays.sort(ArrayWordFromFile);
            return ArrayWordFromFile;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
