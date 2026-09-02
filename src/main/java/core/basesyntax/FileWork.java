package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String[] value = builder.toString().split("\\W+");
        Arrays.sort(value);
        ArrayList<String> sortedWords = new ArrayList<>();
        for (String var : value) {
            if (var.startsWith("W") || var.startsWith("w")) {
                sortedWords.add(var.toLowerCase());
            }
        }
        Collections.sort(sortedWords);
        return sortedWords.toArray(new String[0]);
    }

}
