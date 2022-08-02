package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String CHAR = "w";

    public String[] readFromFile(String fileName) {
        List<String> strings;
        try {
            strings = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s).append(" ");
        }
        String[] newSentence = builder.toString().split("\\W+");
        int length = 0;
        for (String newS : newSentence) {
            if (newS.toLowerCase().startsWith(CHAR)) {
                length++;
            }
        }
        String[] result = new String[length];
        int index = 0;
        for (String res : newSentence) {
            if (res.toLowerCase().startsWith(CHAR)) {
                result[index] = res.toLowerCase();
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
