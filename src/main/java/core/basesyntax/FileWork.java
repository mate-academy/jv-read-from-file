package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File inputFile = new File(fileName);
        StringBuilder inputStringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String nextLine = reader.readLine();
            while (nextLine != null) {
                inputStringBuilder.append(nextLine).append(System.lineSeparator());
                nextLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        String inputString = inputStringBuilder.toString().toLowerCase();
        if (inputString.isEmpty() || inputString.isBlank()) {
            return new String[0];
        }
        String regexWordSeparator = "\\W+";
        String[] words = inputString.split(regexWordSeparator);
        if (words.length == 0 || words[0].isEmpty()) {
            return new String[0];
        }
        Arrays.sort(words);
        final char filterBeginChar = 'w';
        int filteredBeginIndex = -1;
        int filteredEndIndex = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == filterBeginChar) {
                if (filteredBeginIndex == -1) {
                    filteredBeginIndex = i;
                }
                filteredEndIndex = i;
            }
        }
        if (filteredBeginIndex == -1) {
            return new String[0];
        }
        return Arrays.copyOfRange(words, filteredBeginIndex, filteredEndIndex + 1);
    }
}
