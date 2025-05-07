package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder string = new StringBuilder();
        String line = " ";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (line != null) {
                string.append(line);
                string.append(' ');
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IO Error");
        }
        if (string.length() == 0) {
            return new String[0];
        }
        String[] resultStringArray = string.toString().split(" ");
        string.setLength(0);
        for (String word: resultStringArray) {
            if (word.isEmpty()) {
                continue;
            }
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                string.append(word.replaceAll("[^A-Za-z0-9]", "").toLowerCase());
                string.append(' ');
            }
        }
        if (string.length() == 0) {
            return new String[0];
        } else {
            return Arrays.stream(string.toString().split(" ")).sorted().toArray(String[]::new);
        }
    }
}
