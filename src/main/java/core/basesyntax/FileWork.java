package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int ZERO = 0;

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileLine = reader.readLine();
            while (fileLine != null) {
                String[] lineLowerSplit = fileLine.toLowerCase().split(" ");
                for (int i = 0; i < lineLowerSplit.length; i++) {
                    if ("w".equals(String.valueOf(lineLowerSplit[i].charAt(ZERO)))) {
                        lineLowerSplit[i] = lineLowerSplit[i].replaceAll("\\W+", "");
                        builder.append(lineLowerSplit[i]).append(".");
                    }
                }
                fileLine = reader.readLine();
            }
            if (builder.toString().equals("")) {
                return new String[]{};
            } else {
                String[] arrayWordsWithW = builder.toString().split("\\.");
                Arrays.sort(arrayWordsWithW);
                return arrayWordsWithW;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
