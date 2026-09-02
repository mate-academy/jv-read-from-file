package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        StringBuilder bldr = new StringBuilder();
        try {
            BufferedReader bufRdr = new BufferedReader(new FileReader(myFile));
            String string = bufRdr.readLine();
            while (string != null) {
                String[] splitedString = string.toLowerCase()
                        .replaceAll("[,.;!?]", "")
                        .split(" ");
                for (String word : splitedString) {
                    if (word.charAt(0) == 'w') {
                        bldr.append(word).append(" ");
                    }
                }
                string = bufRdr.readLine();
            }
            String[] filteredWords = bldr.toString().split(" ");
            Arrays.sort(filteredWords);
            return bldr.length() == 0 ? new String[0] : filteredWords;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read a file", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(readFromFile("test1")));
    }
}
