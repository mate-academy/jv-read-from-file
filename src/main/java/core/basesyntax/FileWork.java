package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String text;
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            text = builder.toString().toLowerCase();
            if (text.length() == 0) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file");
        }
        String[] splitedText = text.split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String word : splitedText) {
            if (word.charAt(0) == 'w') {
                builder.append(word + ' ');
            }
        }
        String finalText = builder.toString();
        if (finalText.length() == 0) {
            return new String[0];
        }
        String[] neededWords = finalText.split("\\W+");
        Arrays.sort(neededWords);
        return neededWords;
    }
}
