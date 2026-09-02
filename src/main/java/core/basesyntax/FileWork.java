package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String[] sortedArray;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String text = bufferedReader.readLine();
            while (text != null) {
                String[] textArr = text.split("\\W+");
                for (String string : textArr) {
                    String lowerCaseWord = string.toLowerCase();
                    if (lowerCaseWord.charAt(0) == SPECIFIED_CHARACTER) {
                        stringBuilder.append(lowerCaseWord).append(" ");
                    }
                }
                text = bufferedReader.readLine();
            }
            String specialWords = stringBuilder.toString();
            if (specialWords.length() == 0) {
                return new String[0];
            }
            sortedArray = specialWords.split(" ");
            Arrays.sort(sortedArray);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
        return sortedArray;
    }
}
