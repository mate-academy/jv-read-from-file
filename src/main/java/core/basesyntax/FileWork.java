package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER_SMALL = "w";
    private static final String SPECIFIED_CHARACTER_UPPER = "W";
    private List<String> words = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(new File(fileName).getAbsolutePath());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] arrOfWords = value.split(" ");
                for (int i = 0; i < arrOfWords.length; i++) {
                    if (arrOfWords[i].startsWith(SPECIFIED_CHARACTER_SMALL)
                            || arrOfWords[i].startsWith(SPECIFIED_CHARACTER_UPPER)) {
                        words.add(arrOfWords[i].toLowerCase().replaceAll("\\W", ""));
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        Collections.sort(words);

        String[] finalResult = new String[words.size()];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = words.get(i);
        }
        return finalResult;
    }
}
