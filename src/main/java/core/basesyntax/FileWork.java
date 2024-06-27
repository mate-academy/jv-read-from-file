package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String readText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                readText = String.valueOf(stringBuilder.append((char) value)).toLowerCase();
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error ", e);
        }

        String [] parts = readText.split("\\W+");
        int counter = 0;

        for (String word: parts) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                counter++;
            }
        }

        String [] sortedTextBySpecifiedChar = new String[counter];
        int index = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith(SPECIFIED_CHARACTER)) {
                sortedTextBySpecifiedChar[index++] = parts[i];
            }
        }
        return sortedTextBySpecifiedChar.length > 1 ? sortedTextBySpecifiedChar : new String[]{};
    }
}
