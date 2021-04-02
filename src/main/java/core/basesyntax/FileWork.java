package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] resultArray;
        ArrayList<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String stringOfFile = bufferedReader.readLine();
            while (stringOfFile != null) {
                stringBuilder.append(stringOfFile).append(" ");
                stringOfFile = bufferedReader.readLine();
            }
            String[] splitDataArray = stringBuilder.toString().toLowerCase().split(" ");
            for (String word : splitDataArray) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    result.add(word.replaceAll("[^a-z]", ""));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        resultArray = new String[result.size()];
        resultArray = result.toArray(resultArray);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
