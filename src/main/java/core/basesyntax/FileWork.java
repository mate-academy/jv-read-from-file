package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write data to the file " + "'" + fileName + "'");
        }
        String[] splitedBuilder = builder.toString()
                .replaceAll("W", "w")
                .replaceAll("[,.!?]", "")
                .split("\\s+");
        int count = 0;
        for (String newSplitedString : splitedBuilder) {
            if (newSplitedString.charAt(0) == SPECIFIED_CHARACTER) {
                count++;
            }
        }
        String[] resultArr = new String[count];
        int index = 0;
        for (String resultString : splitedBuilder) {
            if (resultString.charAt(0) == SPECIFIED_CHARACTER) {
                resultArr[index++] = resultString;
            }
        }
        Arrays.sort(resultArr);
        return resultArr;
    }
}
