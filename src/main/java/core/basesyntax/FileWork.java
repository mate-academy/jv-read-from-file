package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String [] letterWWords = new String [0];
        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            String [] wordsOfLine;
            while (line != null) {
                wordsOfLine = line.toLowerCase().split(" ");
                for (String word : wordsOfLine) {
                    if (word.charAt(0) == 'w') {
                        buffer.append(word).append(" ");
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File can't reader");
        }
        if (buffer.toString().isEmpty()) {
            return letterWWords;
        }
        String string = buffer.toString();
        String [] arrWords = string.split(" ");
        string = "";
        for (String word : arrWords) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    string += word.charAt(i);
                } else {
                    break;
                }
            }
            string += " ";
        }
        letterWWords = string.split(" ");
        Arrays.sort(letterWWords);
        return letterWWords;
    }
}
