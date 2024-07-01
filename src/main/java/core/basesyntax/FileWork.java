package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error ", e);
        }

        String [] parts = stringBuilder.toString().toLowerCase().split("\\W+");
        ArrayList<String> sortedText = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith(SPECIFIED_CHARACTER)) {
                sortedText.add(parts[i]);
            }
        }
        Collections.sort(sortedText);
        return sortedText.toArray(new String[0]);
    }
}
