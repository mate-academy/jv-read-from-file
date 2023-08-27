package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int INDEX_OF_A = 65;
    private static final int INDEX_OF_Z = 90;
    private static final int INDEX_OF_a = 97;
    private static final int INDEX_OF_z = 122;
    private static final int INDEX_OF_SPACE = 32;
    private static final int INDEX_OF_NEWLINE = 10;
    private static final int END_OF_TEXT = -1;

    public String [] readFromFile(String fileName) {
        StringBuilder stringBuilderBuffer = new StringBuilder();
        String fromStringBuilderToString = null;
        String [] arrayBuffer = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            while (value != END_OF_TEXT) {
                if ((value >= INDEX_OF_A && value <= INDEX_OF_Z)
                        || (value >= INDEX_OF_a && value <= INDEX_OF_z)
                        || (value == INDEX_OF_SPACE)
                        || (value == INDEX_OF_NEWLINE)) {
                    if (value == INDEX_OF_NEWLINE) {
                        value = INDEX_OF_SPACE;
                    }
                    stringBuilderBuffer.append((char)value);
                }
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not found", e);
        }
        fromStringBuilderToString = stringBuilderBuffer.toString().toLowerCase();
        arrayBuffer = fromStringBuilderToString.split(" ");
        Arrays.sort(arrayBuffer);
        stringBuilderBuffer = new StringBuilder();
        for (String s : arrayBuffer) {
            if (s.startsWith("w")) {
                stringBuilderBuffer.append(s).append(" ");
            }
        }
        fromStringBuilderToString = stringBuilderBuffer.toString();
        arrayBuffer = fromStringBuilderToString.split(" ");
        if ((arrayBuffer.length == 0) || (arrayBuffer[0].equals(""))) {
            arrayBuffer = new String[0];
        }
        return arrayBuffer;
    }
}
