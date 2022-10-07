package core.basesyntax;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);

        try {
            builder.append(Files.readAllLines(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }

        if (builder.length() == 2) {
            return new String[0];
        }

        String[] buffer = builder.toString()
                .replaceAll("\\W+", " ")
                .trim().toLowerCase().split(" ");

        StringBuilder builder1 = new StringBuilder();
        for (String str : buffer) {
            if (str.charAt(0) == 'w' && str.length() > 1) {
                builder1.append(str).append(' ');
            }
        }

        if (builder1.length() == 0) {
            return new String[0];
        }

        String[] result = builder1.toString().split(" ");
        Arrays.sort(result);
        return result;

    }
}
