package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] empty = new String[0];
        StringBuilder builder = new StringBuilder();
        StringBuilder newBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String string = reader.readLine();
            while (string != null) {
                builder.append(string).append(System.lineSeparator());
                string = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
        if (!builder.toString().equals("") && builder.toString() != null) {
            String currentFile = builder.toString().toLowerCase();
            String[] fileToArray = currentFile.split("\\W+");
            Arrays.sort(fileToArray);
            String cleanFile = Arrays.toString(fileToArray);
            String c = cleanFile.replaceAll("[,\\[\\]]", "");
            String[] cleanArray = c.split(" ");

            for (int i = 0; i < cleanArray.length; i++) {
                char[] chars = cleanArray[i].toCharArray();
                if (chars[0] == 'w') {
                    newBuilder.append(cleanArray[i]).append(" ");
                }
            }
            String finalString = newBuilder.toString();
            if (finalString.equals("")) {
                return empty;
            } else {
                return finalString.split(" ");
            }
        } else {
            return empty;
        }
    }
}
