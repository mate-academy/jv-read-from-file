package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final int LOWERCASE_A = 97;
    private static final int LOWERCASE_Z = 122;
    private static final int UPPERCASE_A = 65;
    private static final int UPPERCASE_Z = 90;
    private static final int END_OF_FILE = -1;
    private static final int INITIAL_LENGTH = 0;
    private static final int ASCII_W = 119;
    private static final int EMPTY_RESULT_INDEX = 0;

    public String[] readFromFile(String fileName) {
        int lastIndex = fileName.lastIndexOf("\\");
        String correctPath = Paths.get("./") + fileName.substring(lastIndex + 1);
        int indexOf = 0;
        File file = new File(correctPath);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != END_OF_FILE) {
                if (value < UPPERCASE_A || (value > UPPERCASE_Z
                        && value < LOWERCASE_A) || value > LOWERCASE_Z) {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append((char) value);
                }
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
        String onlyWords = stringBuilder.toString().toLowerCase();
        String[] splitAllWordsArray = onlyWords.split(" ");
        Arrays.sort(splitAllWordsArray);
        stringBuilder.setLength(INITIAL_LENGTH);

        for (String currentString : splitAllWordsArray) {
            if (indexOf == currentString.indexOf(ASCII_W)) {
                stringBuilder.append(currentString).append(" ");
            }
        }
        String onlyWordWithW = stringBuilder.toString();
        String[] resultArray = onlyWordWithW.split(" ");
        String[] emptyArray = {};
        return (resultArray[EMPTY_RESULT_INDEX].isEmpty()) ? emptyArray : resultArray;
    }
}
