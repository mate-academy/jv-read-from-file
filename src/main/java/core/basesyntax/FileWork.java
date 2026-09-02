package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String fileContent = Files.readString(file.toPath());
            String[] words = fileContent.toLowerCase().split("[\\s\\p{Punct}]+");

            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(SPECIFIED_CHARACTER)) {
                    if (i < words.length - 1) {
                        stringBuilder.append(words[i]).append(" ");
                    } else {
                        stringBuilder.append(words[i]);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        }

        String[] resultArray = stringBuilder.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
