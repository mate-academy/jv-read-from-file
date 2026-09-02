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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.isEmpty()) {
            return new String[0];
        }
        String fileToString = stringBuilder.toString().toLowerCase();
        String[] fileSplit = fileToString.split("\\W+");
        int lengthResultArray = 0;
        for (String word : fileSplit) {
            if (word.charAt(0) == SPECIFIED_CHARACTER) {
                lengthResultArray++;
            }
        }
        if (lengthResultArray == 0) {
            return new String[0];
        }
        String[] unsortedResult = new String[lengthResultArray];
        int indexUnsortedResult = 0;
        for (int i = 0; i < fileSplit.length; i++) {
            if (fileSplit[i].charAt(0) == SPECIFIED_CHARACTER) {
                unsortedResult[indexUnsortedResult] = fileSplit[i];
                indexUnsortedResult++;
            }
        }
        Arrays.sort(unsortedResult);
        return unsortedResult;
    }
}
