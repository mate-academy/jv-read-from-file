package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != -1) {
                if (notEndOfWord(value)) {
                    if (Character.toLowerCase((char)value) == SPECIFIED_CHARACTER) {
                        if (builder.length() != 0) {
                            builder.append(' ');
                        }
                        do {
                            builder.append(Character.toLowerCase((char) value));
                            value = reader.read();
                        } while (notEndOfWord(value));
                    } else {
                        do {
                            value = reader.read();
                        } while (notEndOfWord(value));
                    }
                } else {
                    value = reader.read();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read from file");
        }
        return toStringArray(builder);
    }

    public boolean notEndOfWord(int value) {
        return (char) value != ' '
                && (char) value != '.'
                && (char) value != ','
                && (char) value != '-'
                && (char) value != '!'
                && (char) value != '?'
                && (char) value != '\n'
                && (char) value != '\r'
                && value != -1;
    }

    public String [] toStringArray(StringBuilder builder) {
        if (builder.length() != 0) {
            String [] result = builder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } else {
            return new String[] {};
        }
    }
}
