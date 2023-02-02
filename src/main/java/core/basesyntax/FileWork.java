package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String[] found;
        int nextChar;
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            nextChar = reader.read();
            while (nextChar != -1) {
                if (isLetter(nextChar)) {
                    builder.append((char) nextChar);
                } else {
                    if (!builder.isEmpty()
                            && (builder.charAt(0) == 'w' || builder.charAt(0) == 'W')) {
                        filteredWords.add(builder.toString().toLowerCase());
                    }
                    builder = new StringBuilder();
                }
                nextChar = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(filteredWords);
        found = new String[filteredWords.size()];
        found = filteredWords.toArray(found);

        return found;
    }

    public boolean isLetter(int charNum) {
        return (charNum > 64 && charNum < 91) || (charNum > 96 && charNum < 123);
    }
}
