package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> resultList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            String stringFromFile = builder.toString();
            String[] arrayOfStrings = stringFromFile.split("[\\p{Punct}\\s]+");

            for (String word : arrayOfStrings) {
                if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    resultList.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading or closing the file");
        }

        String[] resultArray = new String[resultList.size()];
        resultList.toArray(resultArray);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
