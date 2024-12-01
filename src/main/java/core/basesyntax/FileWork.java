package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String FILTER_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        File file = new File(fileName);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();

            while (value != null) {
                String[] line = value.split("\\W+");

                for (String s : line) {
                    String lowerCaseString = s.toLowerCase();

                    if (lowerCaseString.startsWith(FILTER_CHARACTER)) {
                        words.add(lowerCaseString);
                    }
                }

                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] wordsArr = words.toArray(new String[0]);
        Arrays.sort(wordsArr);

        return wordsArr;
    }
}
