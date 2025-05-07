package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> strings;
        List<String> resultList = new ArrayList<>();
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("IOException", e);
        }
        for (String clearString : strings) {
            String[] withoutSymbols = clearString.toLowerCase().split("\\W+");
            for (int i = 0; i < withoutSymbols.length; i++) {
                if (withoutSymbols[i].startsWith(CHARACTER)) {
                    resultList.add(withoutSymbols[i]);
                }
            }
            if (resultList.equals(null)) {
                return new String[0];
            }
        }
        String[] result = resultList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
