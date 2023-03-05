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
        StringBuilder resultBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(' ');
                line = reader.readLine();
            }
            if (builder.toString().length() == 0) {
                return new String[0];
            }
            String[] words = builder.toString().toLowerCase().split("\\W+");
            for (String str : words) {
                if (str.charAt(0) == 'w') {
                    resultBuilder.append(str).append(" ");
                }
            }
            if (resultBuilder.toString().length() == 0) {
                return new String[0];
            }
            String[] result = resultBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
