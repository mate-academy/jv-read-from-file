package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WHITE_SPACE_RX = " ";
    private static final String PUNCTUATION_RX = "[^a-zA-Z0-9_]";

    public String[] readFromFile(String fileName) {
        try {
            if (readFile(fileName).length() == 0) {
                return new String[]{};
            } else {
                String[] arr = readFile(fileName).split(WHITE_SPACE_RX);
                if (takeNeededWords(arr).length == 0) {
                    return new String[]{};
                } else {
                    String[] returnArr = takeNeededWords(arr);
                    Arrays.sort(returnArr);
                    return returnArr;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't create the file", e);
        }
    }

    public String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int value = bufferedReader.read();
        if (value == -1) {
            return "";
        } else {
            while (value > -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            return stringBuilder.toString().replaceAll(PUNCTUATION_RX, " ");
        }

    }

    public String[] takeNeededWords(String[] arr) {
        StringBuilder newString = new StringBuilder();
        for (String s : arr) {
            if ((s.startsWith("w") || s.startsWith("W"))) {
                newString
                        .append(s.replaceAll(PUNCTUATION_RX, "").toLowerCase())
                        .append(" ");
            }
        }
        if (newString.length() == 0) {
            return new String[]{};
        } else {
            return newString.toString().trim().split(WHITE_SPACE_RX);
        }
    }
}
