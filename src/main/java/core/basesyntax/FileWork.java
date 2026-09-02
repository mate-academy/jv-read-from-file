package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private BufferedReader bufferedReader;

    private String[] strings;
    private StringBuilder stringBuilder;

    public String[] readFromFile(String fileName) {
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            strings = stringBuilder.toString().toLowerCase().split("\\W+");
            stringBuilder.setLength(0);
            for (int i = 0; i < strings.length; i++) {
                char character = strings[i].charAt(0);
                if (character == SPECIFIED_CHARACTER) {
                    stringBuilder.append(strings[i]);
                    stringBuilder.append(" ");
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            } else {
                String[] sortString = stringBuilder.toString().split(" ");
                int size = sortString.length;
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < sortString.length; j++) {
                        if (sortString[i].compareTo(sortString[j]) > 0) {
                            String temp = sortString[i];
                            sortString[i] = sortString[j];
                            sortString[j] = temp;
                        }
                    }
                }
                return sortString;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("We can't read the file!",e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
