package core.basesyntax;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String PUNCTUATION_PATTERN = "[.,!?-]";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String cleanedString = stringBuilder.toString().toLowerCase().replaceAll(PUNCTUATION_PATTERN,"");
            String[] splitArray = cleanedString.split(" ");
            return bySymbolWordFinder(splitArray, SPECIFIED_CHARACTER);
        }
        catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public String[] bySymbolWordFinder (String[] strings, String character) {
        int size = 0;
        if (strings.length == 0) {
            return new String[] {};
        }
        for (String string : strings) {
            if (string.startsWith(character)) {
                size++;
            }
        }
        String[] result = new String[size];
        for (String string : strings) {
            int i = 0;
            if (string.startsWith(character)) {
                result[i] = string;
                i++;
            }
        }
        return Arrays.sort();
    }
}
