package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX_EXCEPTION = "\\W+";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String[] arrayWordsBeginsOnthW = null;
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder stringBuilder = new StringBuilder();
                int readeValue = reader.read();

                while (readeValue != -1) {
                    stringBuilder.append((char) readeValue);
                    readeValue = reader.read();
                }

                StringBuilder startedWithW = new StringBuilder();
                for (String s : stringBuilder.toString().toLowerCase().split(REGEX_EXCEPTION)) {
                    if (s.startsWith(SPECIFIED_CHARACTER)) {
                        startedWithW.append(s).append(System.lineSeparator());
                    }
                }
                if (startedWithW.toString().length() != 0) {
                    arrayWordsBeginsOnthW = startedWithW.toString().split(System.lineSeparator());
                } else {
                    arrayWordsBeginsOnthW = new String[0];
                }
                Arrays.sort(arrayWordsBeginsOnthW);
            } catch (IOException e) {
                throw new RuntimeException("Can't read file", e);
            }
        }
        return arrayWordsBeginsOnthW;
    }
}
