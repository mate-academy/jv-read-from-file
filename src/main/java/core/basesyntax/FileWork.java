package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String START_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> comparingResult = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readerValue = bufferedReader.readLine();
            while (readerValue != null) {
                builder.append(readerValue).append(System.lineSeparator());
                readerValue = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException("Can`t read file, file is Empty!", exception);
        }
        String[] inputArray = builder.toString().toLowerCase().split("\\s+");
        for (String singleWord : inputArray) {
            singleWord = singleWord.replaceAll("\\W", "");
            if (singleWord.startsWith(START_CHARACTER)) {
                comparingResult.add(singleWord);
            }
        }
        Collections.sort(comparingResult);
        return comparingResult.toArray(new String[0]);
    }
}
