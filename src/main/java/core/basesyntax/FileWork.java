package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = new String[0];

        if (file.length() != 0) {
            String[] fileDataArray = readFile(file);
            StringBuilder wordsStartsW = new StringBuilder();

            for (int i = 0; i < fileDataArray.length; i++) {
                if (startWithLetter(fileDataArray[i])) {
                    wordsStartsW.append(fileDataArray[i].replaceAll("[^\\p{Alnum}\\s]", ""))
                            .append(" ");
                }
            }

            if (wordsStartsW.length() > 0) {
                result = wordsStartsW.toString().split(" ");
                Arrays.sort(result);
            }
        }
        return result;
    }

    private String[] readFile(File file) {
        StringBuilder wordsArray = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String value = reader.readLine();
            while (value != null) {
                wordsArray.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return wordsArray.toString().toLowerCase().split(" ");
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
