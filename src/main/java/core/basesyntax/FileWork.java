package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        BufferedReader bufferedReader = null;
        StringBuilder builder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            String text = bufferedReader.readLine();
            while (text != null) {
                for (String word : text.split("[ ,.,?,,,!]")) {
                    String lowerWord = word.toLowerCase();
                    if (lowerWord.toLowerCase().startsWith("w")) {
                        builder.append(lowerWord).append(" ");
                    }
                }
                text = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not founded!");
        } catch (IOException e) {
            throw new RuntimeException("Can't read from buffered reader!");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close buffered reader!");
                }
            }
        }
        if (builder.length() < 1) {
            return new String[0];
        }
        String[] words = builder.deleteCharAt(builder.length() - 1).toString().split(" ");
        Arrays.sort(words);
        return words;
    }
}
