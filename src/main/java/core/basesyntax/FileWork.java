package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder textBuilder = new StringBuilder();
        BufferedReader br = null;

        try  {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                textBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new String[0];
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error closing reader: " + e.getMessage());
                }
            }
        }

        String[] allWords = textBuilder.toString().toLowerCase().split("[^a-zA-Z]+");

        int count = 0;
        for (String word : allWords) {
            if (word.startsWith("w")) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;

        for (String word : allWords) {
            if (word.startsWith("w")) {
                result[index++] = word;
            }
        }

        Arrays.sort(result);
        return result;
    }
}
