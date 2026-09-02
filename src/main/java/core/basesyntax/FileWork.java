package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        StringBuilder finalBuild = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        String[] split = builder.toString().split("\\W+");
        for (String fraze : split) {
            if (fraze.toLowerCase().startsWith("w")) {
                finalBuild.append(fraze.toLowerCase()).append(" ");
            }
        }
        if (finalBuild.isEmpty()) {
            return new String[0];
        }
        String resultString = finalBuild.toString();
        String[] finalTable = resultString.split(" ");
        Arrays.sort(finalTable);
        return finalTable;
    }
}
