package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final char SPACE_CHARACTER = ' ';
    private static final String NEW_LINE_CHARACTER = System.lineSeparator();
    private static final String IGNORED_CHARACTERS = "!?,.\" " + System.lineSeparator();
    private StringBuilder stringBuilder = new StringBuilder();

    private boolean isEmptyResult(StringBuilder stringBuilder) {
        return stringBuilder.toString().equals("");
    }

    public String[] readFromFile(String fileName) {
        //write your code here
        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader(new File(fileName)))) {
            stringBuilder.setLength(0);
            int value = bufferedReader.read();
            boolean isWFirst = false;
            boolean isBeginningOfWord = true;
            char charValue;
            while (value != -1) {
                charValue = Character.toLowerCase((char) value);
                ;
                if (charValue == SPACE_CHARACTER
                        || NEW_LINE_CHARACTER.equals(String.valueOf(charValue))) {
                    if (isWFirst) {
                        stringBuilder.append(SPACE_CHARACTER);
                    }
                    isBeginningOfWord = true;
                    value = bufferedReader.read();
                    continue;
                }
                if (isBeginningOfWord) {
                    if (charValue == SPECIFIED_CHARACTER) {
                        isWFirst = true;
                        stringBuilder.append(charValue);
                    } else {
                        isWFirst = false;
                    }
                    isBeginningOfWord = false;
                    value = bufferedReader.read();
                    continue;
                }
                if (isWFirst) {
                    if (IGNORED_CHARACTERS.indexOf(charValue) != -1) {
                        value = bufferedReader.read();
                        continue;
                    }
                    stringBuilder.append(charValue);
                }
                value = bufferedReader.read();
            }
            if (isEmptyResult(stringBuilder)) {
                return new String[0];
            }
            String[] result = stringBuilder.toString().split(" ");

            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
