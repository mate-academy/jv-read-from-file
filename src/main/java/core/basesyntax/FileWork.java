package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char START_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder testFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String test = reader.readLine();
            while (test != null) {
                testFromFile.append(test).append(" ");
                test = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return justDoubleVeeWords(testFromFile.toString());
    }

    public String[] justDoubleVeeWords(String text) {
        if (text.equals("")) {
            return new String[]{};
        }

        String[] testArray = text.toLowerCase().replaceAll("[!\\.,?]", "").split(" ");
        StringBuilder onlyWordsWithW = new StringBuilder();
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i].charAt(0) == START_CHARACTER) {
                onlyWordsWithW.append(testArray[i]);
                if (i < testArray.length - 1) {
                    onlyWordsWithW.append(" ");
                }
            }
        }

        String[] preReturn = onlyWordsWithW.toString().split(" ");
        if (preReturn[0].equals("")) {
            return new String[]{};
        }
        Arrays.sort(preReturn);
        return preReturn;
    }
}
