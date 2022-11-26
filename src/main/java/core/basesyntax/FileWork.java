package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String str = strings.toString().toLowerCase();
            if (str.equals("[]")) {
                return new String[] {};
            }

            String[] fileString = str.split("\\W+");

            for (String name : fileString) {
                if (name.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(name + " ");
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[] {};
            }

            String appendedString = stringBuilder.toString();
            String[] finalString = appendedString.split(" ");
            Arrays.sort(finalString);

            return finalString;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + e);
        }

    }
}
