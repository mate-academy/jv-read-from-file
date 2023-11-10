package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String dataFromFile = bufferedReader.readLine();
            String [] result = {};
            while (dataFromFile != null) {
                stringBuilder.append(dataFromFile).append(System.lineSeparator());
                dataFromFile = bufferedReader.readLine();

            }
            if (stringBuilder.isEmpty()) {
                return result;
            }
            String [] stringArray = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder newStringBuilder = new StringBuilder();
            boolean startsWithW = false;
            for (String string : stringArray) {
                if (string.charAt(0) == SPECIFIED_CHARACTER) {
                    newStringBuilder.append(string).append(" ");
                    startsWithW = true;
                }
            }
            if (!startsWithW) {
                return result;
            }
            result = newStringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
