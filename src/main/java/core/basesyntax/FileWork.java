package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private static final String START_SYMBOL = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> output;
        List<String> listForSort = new ArrayList<>();
        String[] result;
        try {
            output = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        for (String data : output) {
            String[] sortedWords = data.toLowerCase().split("\\W+");
            for (String sortWord : sortedWords) {
                if (sortWord.startsWith(START_SYMBOL)) {
                    listForSort.add(sortWord);
                }
            }
        }
        result = listForSort.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
