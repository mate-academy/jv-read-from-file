package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHECK_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String textFromFile = "";
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                String word = bufferedReader.readLine();
                String[] words = word.split(" ");
                for (String string : words) {
                    if (string.toLowerCase().startsWith(CHECK_LETTER)) {
                        textFromFile += string.toLowerCase().replaceAll("[!\\.,?]", "") + " ";
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        if (textFromFile.length() == 0) {
            String[] emptyArr = new String[0];
            return emptyArr;
        }
        String[] textArray = textFromFile.split(" ");
        Arrays.sort(textArray);
        return textArray;
    }
}
