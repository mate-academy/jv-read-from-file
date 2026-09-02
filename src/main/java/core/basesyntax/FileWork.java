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
        StringBuilder builder2 = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader((file)))) {
            String value = reader.readLine();

            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant't read from file", e);
        }

        String[] all = builder.toString().toLowerCase().replaceAll("\\p{P}", "").split(" ");
        for (String word : all) {
            if (word.startsWith("w")) {
                builder2.append(word).append(" ");
            }
        }
        String[] result = builder2.toString().split(" ");
        if (result[0].isEmpty()) {
            return new String[0];
        }
        Arrays.sort(result);
        return result;

    }
}
