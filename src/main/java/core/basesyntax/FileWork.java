package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPLIT_CHARACTER = " ";
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private static final String REPLACEMENT_CHARACTER = "";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                String[] stringArr = value.split(SPLIT_CHARACTER);
                for (String string: stringArr) {
                    if (string.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        builder.append(string.toLowerCase()).append(SPLIT_CHARACTER);
                    }
                }
                value = reader.readLine();
            }

            if (builder.toString().isEmpty()) {
                return new String[0];
            }
            String[] filteredStrings = builder.toString()
                    .replaceAll(PUNCTUATION_REGEX, REPLACEMENT_CHARACTER)
                    .split(SPLIT_CHARACTER);
            return stringToNaturalOrder(filteredStrings);
        } catch (IOException e) {
            throw new RuntimeException("Error");
        }
    }

    public static String[] stringToNaturalOrder(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].compareTo(strings[j]) > 0) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }
}
