package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                sb.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            if (sb.length() == 0) {
                return new String[0];
            }
            String[] words = sb.toString().toLowerCase().split("\\W+");
            Arrays.sort(words);
            for (String word : words) {
                System.out.println(word);
            }
            StringBuilder selectedWords = new StringBuilder();
            for (String word : words) {
                if (word.charAt(0) == 'w') {
                    selectedWords.append(word).append(" ");
                }
            }
            if (selectedWords.length() == 0) {
                return new String[0];
            }
            return selectedWords.toString().trim().split(" ");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
