package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileWork {
    private static final String START_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> comparingResult = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String readerValue = bufferedReader.readLine();
            while (readerValue != null) {
                builder.append(readerValue).append(System.lineSeparator());
                readerValue = bufferedReader.readLine();
            }
            String[] inputArray = builder.toString().split("\\s+");
            for (String singleWord : inputArray) {
                singleWord = singleWord.replaceAll("\\W", "").toLowerCase();
                if (singleWord.startsWith(START_CHARACTER)) {
                    comparingResult.add(singleWord);
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException("Can`t read file, file is Empty!" + exception);
        }
        Collections.sort(comparingResult);
        return comparingResult.toArray(new String[0]);
    }
}
