package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final char SIGNIFICANT_INDEX = 'w';

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String input = bufferedReader.readLine();
            if (input != null) {
                while (input != null) {
                    String[] split = input.toLowerCase().split("\\W+");
                    for (String item : split) {
                        if (item.charAt(ZERO_INDEX) == SIGNIFICANT_INDEX) {
                            builder.append(item).append(" ");
                        }
                    }
                    input = bufferedReader.readLine();
                }
                String[] result = builder.toString().split(" ");
                Arrays.sort(result);
                if (result.length != ONE_INDEX) {
                    return result;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file ", e);
        }
        return new String[ZERO_INDEX];
    }
}
