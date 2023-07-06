package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String SORT_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String wordsWithW;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String [] split = stringBuilder.toString().toLowerCase().split(REGEX);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith(SORT_LETTER)) {
                    builder.append(split[i]).append(" ");
                }
            }
            wordsWithW = builder.toString().trim();
            if (wordsWithW.isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Exception", e);
        }
        String [] wordsWithWArray = wordsWithW.split(" ");
        Arrays.sort(wordsWithWArray);
        return wordsWithWArray;
    }
}
