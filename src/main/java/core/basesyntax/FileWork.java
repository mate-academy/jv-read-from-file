package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String EXPECTED_FIRST_LETTER = "w";
    private static final String WHITE_SPACE = " ";
    private static final int ZERO = 0;

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            StringBuilder builderResult = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            String [] split = builder.toString().toLowerCase().split("\\W+");
            for (String s : split) {
                if (s.startsWith(EXPECTED_FIRST_LETTER)) {
                    builderResult.append(s).append(WHITE_SPACE);
                }
            }
            System.out.println(builderResult);
            String [] result = builderResult.toString().split(WHITE_SPACE);
            Arrays.sort(result);
            if (result.length == 1) {
                return new String[ZERO];
            }
            return result;

        } catch (IOException e) {
            throw new RuntimeException("File can't be reading" + e);
        }
    }
}
