package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file ",e);
        }
        String[] splitStringFromFile = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder resultStringBuilder = new StringBuilder();
        if (splitStringFromFile.length > 1) {
            for (int i = 0; i < splitStringFromFile.length; i++) {
                if (splitStringFromFile[i].substring(0, 1).equals(SPECIFIED_CHARACTER)) {
                    resultStringBuilder.append(splitStringFromFile[i]).append(" ");
                }
            }
            String[] result = resultStringBuilder.toString().split(" ");
            if (resultStringBuilder.toString() != "") {
                Arrays.sort(result);
                return result;
            } else {
                return new String[0];
            }
        } else {
            return new String[0];
        }
    }
}
