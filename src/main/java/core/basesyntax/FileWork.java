package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String COMMA = ",";

    public String[] readFromFile(String fileName) {
        boolean inWord = false;
        boolean correctWord = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String string = reader.readLine();
            if (string == null) {
                return new String[0];
            }
            while (string != null) {
                char[] charArray = string.toLowerCase().toCharArray();

                for (char character : charArray) {
                    if (character >= 'a' && character <= 'z' && (!inWord)) {
                        if (character == 'w') {
                            correctWord = true;
                        }
                        inWord = true;
                    }
                    if (character >= 'a' && character <= 'z' && correctWord) {
                        stringBuilder.append(character);
                    }
                    if ((character < 'a' && correctWord) || (character > 'z' && correctWord)) {
                        inWord = false;
                        correctWord = false;
                        stringBuilder.append(COMMA);
                    }
                    if ((character < 'a' && inWord) || (character > 'z' && !correctWord)) {
                        inWord = false;
                    }
                }
                if (inWord && correctWord) {
                    stringBuilder.append(COMMA);
                    inWord = false;
                    correctWord = false;
                }
                string = reader.readLine();
            }
            if (stringBuilder.isEmpty()) {
                return new String[0];
            }
            String[] result = stringBuilder.toString().split(COMMA);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }
}
