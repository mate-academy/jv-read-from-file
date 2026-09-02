package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORD_BEGINS_LETTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String dataLine;
            while ((dataLine = bufferedReader.readLine()) != null) {
                String[] arrayFromDataLine = dataLine.toLowerCase().split("\\W");
                for (String words: arrayFromDataLine) {
                    if (words.startsWith(WORD_BEGINS_LETTER)) {
                        stringBuilder.append(words).append(" ");
                    }
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[]{};
            }
            String[] resultArray = stringBuilder.toString().trim().split(" ");
            Arrays.sort(resultArray);
            return resultArray;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
