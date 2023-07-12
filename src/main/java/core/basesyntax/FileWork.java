package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        ;
        File file = new File(fileName);
        String[] result;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builderReader = new StringBuilder();
            StringBuilder builderWithW = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builderReader.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            if (builderReader.toString().length() == 0) {
                return new String[]{};
            } else {
                String[] strings = builderReader.toString().toLowerCase().split(" ");
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].charAt(0) == SPECIFIED_CHARACTER) {
                        builderWithW.append(strings[i]).append(" ");
                    }
                }
                if (builderWithW.toString().equals("")) {
                    return new String[]{};
                }
                result = builderWithW.toString().split("[\\p{Punct}\\s]+");

                Arrays.sort(result);
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
