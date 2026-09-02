package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_CHAR = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder textBox = new StringBuilder();
        char firstChar = ' ';
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int character;
            File checkFile = new File(fileName);
            if (checkFile.length() == 0) {
                return new String[0];
            }
            while ((character = reader.read()) != -1) {
                textBox.append((char) character);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] tempString = textBox.toString().split("\\W+");
        textBox = new StringBuilder();
        for (String s : tempString) {
            s = s.toLowerCase();
            firstChar = s.toCharArray()[FIRST_CHAR];
            if (firstChar == 'w') {
                textBox.append(s + " ");
            }
        }
        if (textBox.length() == 0) {
            return new String[0];
        }
        String[] result = textBox.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
