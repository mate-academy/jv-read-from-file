package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final Character SPECIFIED_CHARACTER_LOWER = 'w';
    private static final Character SPECIFIED_CHARACTER_UPPER = 'W';
    private static final int ASCI_UPPER_START = 65;
    private static final int ASCI_UPPER_END = 90;
    private static final int ASCI_LOWER_START = 97;
    private static final int ASCI_LOWER_end = 122;

    public String[] readFromFile(String fileName) {
        StringBuilder wordsArrayBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                if (isSpecified(value)) {
                    while (valueIsLetter(value)) {
                        wordsArrayBuilder.append((char) value);
                        value = bufferedReader.read();
                    }
                    wordsArrayBuilder.append(" ");
                } else {
                    while (valueIsLetter(value)) {
                        value = bufferedReader.read();
                    }
                }
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read the file");
        }
        if (wordsArrayBuilder.toString().equals("")) {
            return new String[]{};
        }
        String[] wordsStartingWithW = wordsArrayBuilder.toString().toLowerCase().split(" ");
        Arrays.sort(wordsStartingWithW);
        return wordsStartingWithW;
    }

    private boolean isSpecified(int firstChar) {
        return (char) firstChar == SPECIFIED_CHARACTER_LOWER
                || firstChar == SPECIFIED_CHARACTER_UPPER;
    }

    private boolean valueIsLetter(int value) {
        return value >= ASCI_UPPER_START && value <= ASCI_UPPER_END
                || value >= ASCI_LOWER_START && value <= ASCI_LOWER_end;

    }
}
