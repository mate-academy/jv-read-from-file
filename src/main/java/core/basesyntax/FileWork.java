package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    static final String CHARACTER_DIVIDER = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fileString = reader.readLine();
            while (fileString != null) {
                builder.append(fileString).append(System.lineSeparator());
                fileString = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String fileString = builder.toString().toLowerCase();
        String[] words = fileString.split(CHARACTER_DIVIDER);
        builder.setLength(0);
        for (String word: words) {
            if (word.charAt(0) == 'w') {
                builder.append(word).append(" ");
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String[] result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;

    }
}
