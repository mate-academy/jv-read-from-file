package core.basesyntax;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        String string = new String();
        String result = new String();
        int wPosition = -1;
        int endWordPosition = -1;
        StringBuilder strBuild = new StringBuilder();

        try {
            string = String.valueOf(Files.readAllLines(myFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can`t open file!", e);
        }

        for (int i = 0; i < string.length(); i++) {
            if((string.charAt(i) == 'w' || string.charAt(i) == 'W') &&
                    (i == 1 || string.charAt(i - 1) == ' ')) {
                wPosition = i;
            }
            if(string.charAt(i) >= (char) 32 && string.charAt(i) <= (char) 63 && wPosition != -1) {
                endWordPosition = i;
            }
            if(wPosition != -1 && endWordPosition != -1) {
                result = string.substring(wPosition, endWordPosition);
                result = result.toLowerCase();
                strBuild.append(result).append(' ');
                wPosition = -1;
                endWordPosition = -1;
            }
        }
        String[] words = strBuild.toString().split(" ");
        Arrays.sort(words);
        if(strBuild.isEmpty()) {
            return new String[0];
        }
        return words;
    }
}
