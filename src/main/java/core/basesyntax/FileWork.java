package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final char SPECIFIC_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read the file", e);
        }

        String builderWithoutComas = builder.toString().toLowerCase().replaceAll("[,.!?]", "");
        String[] checkingVariableW = builderWithoutComas.split("[\\r\\n\\s]+");
        ArrayList<String> wordsVariableW = new ArrayList<>();

        if (!builderWithoutComas.isEmpty()) {
            for (String s : checkingVariableW) {
                if (s.charAt(0) == SPECIFIC_CHAR) {
                    wordsVariableW.add(s);
                }
            }
            Collections.sort(wordsVariableW);
        }

        return wordsVariableW.toArray(new String[0]);
    }
}

