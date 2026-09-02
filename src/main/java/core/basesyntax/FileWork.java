package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {

    private static final char SPECIFIED_CHARACTER = 'w';
    private static final int FIRST_CHARACTER = 0;

    public String[] readFromFile(String fileName) {
        String[] tmp;
        StringBuilder resultBuilder = new StringBuilder();
        try {
            tmp = Files.readString(Path.of(fileName)).split("[^\\w']+");
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
        if (tmp[0].isEmpty()) {
            return new String[0];
        }
        for (String s : tmp) {
            if (s.toLowerCase().charAt(FIRST_CHARACTER) == SPECIFIED_CHARACTER) {
                resultBuilder.append(s.toLowerCase()).append(" ");
            }
        }
        if (resultBuilder.length() > 0) {
            tmp = resultBuilder.toString().split(" ");
            Arrays.sort(tmp);
            return tmp;
        } else {
            return new String[0];
        }
    }
}
