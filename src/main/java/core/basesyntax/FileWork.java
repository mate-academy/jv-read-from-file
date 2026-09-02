package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            return patternResult(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] patternResult(StringBuilder stringBuilder) {
        String[] result;
        String[] supplyArray = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String word : supplyArray) {
            if (word.startsWith("w")) {
                builder.append(word).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[]{};
        }
        result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
