package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String output;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            output = stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Reader not create!");
        }
        output = output.replaceAll("[.,?!]", "");
        String[] words = output.split("\\s");
        int wordsWithW = 0;
        for (String word : words) {
            if (word == "") {
                word = "null";
            }
            char ar = word.charAt(0);
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                System.out.println(word.toLowerCase());
                wordsWithW++;
            }
        }
        String [] outputArray = new String[wordsWithW];
        int j = 0;
        for (String word : words) {
            if (word == "") {
                word = "null";
            }
            char ar = word.charAt(0);
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                outputArray[j] = word.toLowerCase();
                j++;
            }
        }
        Arrays.sort(outputArray);
        return outputArray;
    }
}
