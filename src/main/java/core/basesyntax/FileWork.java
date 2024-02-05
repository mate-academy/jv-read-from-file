package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String LETTER_TO_START_WITH = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
            String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
            Arrays.sort(split);
            ArrayList<String> resultList = new ArrayList<>();
            for (String word : split) {
                if (word.startsWith(LETTER_TO_START_WITH)) {
                    resultList.add(word);
                }
            }
            return resultList.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't access the data", e);
        }
    }
}
