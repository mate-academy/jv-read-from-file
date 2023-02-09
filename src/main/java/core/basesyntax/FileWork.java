package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(myFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File does not exist", e);
        }
        String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
        stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(0) == FileWork.SPECIFIED_CHARACTER) {
                stringBuilder.append(strings[i]).append(" ");
            }
        }
        if (stringBuilder.toString().equals("")) {
            return new String[0];
        }
        strings = stringBuilder.toString().split(" ");
        Arrays.sort(strings);
        return strings;
    }
}
