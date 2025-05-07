package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public static String[] readFromFile(String fileName) {
        File textFile = new File(fileName);
        long fileLength = textFile.length();
        FileReader fileReader;
        String[] emptyArray = {};
        if (fileLength != 0) {
            try {
                fileReader = new FileReader(textFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("File wasn't found.", e);
            }
        } else {
            return emptyArray;
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String lineOfFile;
        try {
            lineOfFile = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        String[] splitedLine;
        while (lineOfFile != null) {
            splitedLine = lineOfFile.split("\\W+");
            for (String word : splitedLine) {
                if (word.startsWith(SPECIFIED_CHARACTER)
                        || word.startsWith(SPECIFIED_CHARACTER.toUpperCase())) {
                    stringBuilder.append(word.toLowerCase()).append(" ");
                }
            }
            try {
                lineOfFile = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (stringBuilder.toString().length() != 0) {
            String[] result;
            result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } else {
            return emptyArray;
        }
    }
}
