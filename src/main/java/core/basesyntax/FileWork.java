package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String PUNCTUATION_PATTERN = "\\pP";
    private static final String ERROR_MESSAGE = "Can't read the file: ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String stringValue = bufferedReader.readLine();
            while (stringValue != null) {
                String[] stringValueArray = getStringWithoutPunctuation(stringValue);
                for (String stringItem : stringValueArray) {
                    if (stringItem.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(stringItem).append(" ");
                    }
                }
                stringValue = bufferedReader.readLine();
            }
            if (!stringBuilder.isEmpty()) {
                result = stringBuilder.toString().split(" ");
                Arrays.sort(result);
                return result;
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + file.getName(), e);
        }
    }

    private static String[] getStringWithoutPunctuation(String stringLine) {
        return stringLine
                .toLowerCase()
                .replaceAll(PUNCTUATION_PATTERN, "")
                .split(" ");
    }
}
