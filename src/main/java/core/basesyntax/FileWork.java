package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> withSpecCharList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    String lowerCaseWord = word.toLowerCase();
                    if (lowerCaseWord.startsWith(SPECIFIED_CHARACTER)) {
                        withSpecCharList.add(lowerCaseWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = withSpecCharList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
