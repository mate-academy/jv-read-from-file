package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] spitedBySpaceAndPunctuation = temp.split("[\\s\\p{Punct}]+");
                for (String tempWord : spitedBySpaceAndPunctuation) {
                    if (tempWord.toLowerCase().startsWith("w")) {
                        sb.append(tempWord.toLowerCase());
                        sb.append(" ");
                    }
                }
            }
            if (sb.isEmpty()) {
                return new String[0];
            }
            String[] result = sb.toString().trim().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + e);
        }
    }
}
