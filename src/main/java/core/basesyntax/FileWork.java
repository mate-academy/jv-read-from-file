package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String container;
        File file = new File(fileName);
        try {
            container = String.valueOf(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }

        String[] splitContainer = container.toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        if (splitContainer.length == 0) {
            return new String[0];
        }

        for (String word: splitContainer) {
            if (word.indexOf('w') == 0) {
                builder.append(word).append(" ");
            }
        }
        if (builder.isEmpty()) {
            return new String[0];
        } else {
            String[] resultArray = builder.toString().split("\\W+");
            Arrays.sort(resultArray);
            return resultArray;
        }
    }
}
