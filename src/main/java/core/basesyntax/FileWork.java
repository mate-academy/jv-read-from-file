package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPACE_FOR_SPLIT = " ";
    private static final String LOOKING_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String[] resultW = new String[0];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] split = stringBuilder.toString().toLowerCase().split(SPACE_FOR_SPLIT);
            StringBuilder stringBuilderForW = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replaceAll("[.!?]", "");
                if (split[i].startsWith(LOOKING_LETTER)) {
                    stringBuilderForW = stringBuilderForW.append(split[i]).append(SPACE_FOR_SPLIT);
                }
            }
            resultW = stringBuilderForW.toString().split(SPACE_FOR_SPLIT);
            if (stringBuilderForW.length() == 0) {
                return new String[0];
            }
            Arrays.sort(resultW);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        return resultW;
    }
}
