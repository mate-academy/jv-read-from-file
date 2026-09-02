package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            System.out.println(builder);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] split = builder.toString().toLowerCase().split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String words : split) {
            if (words.startsWith("w")) {
                stringBuilder.append(words).append(" ");
            }
        }
        String[] result = stringBuilder.toString().split(" ");
        if (result[0].isEmpty()) {
            return new String[0];
        }
        Arrays.sort(result);
        return result;
    }
}
