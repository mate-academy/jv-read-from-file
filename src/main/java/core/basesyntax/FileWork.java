package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SORT_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        ArrayList<String> sortedWords = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                String[] splitLine = fileLine.toLowerCase().split("\\W+");
                for (String word : splitLine) {
                    if (word.startsWith(SORT_LETTER)) {
                        sortedWords.add(word);
                    }
                }
                fileLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] resultArray = new String[sortedWords.size()];
        resultArray = sortedWords.toArray(resultArray);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
