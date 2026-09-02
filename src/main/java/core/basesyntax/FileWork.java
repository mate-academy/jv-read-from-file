package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] data = builder.toString().toLowerCase().split("\\W+");
            Arrays.sort(data);
            StringBuilder finalText = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                if (data[i].charAt(0) == 'w') {
                    finalText.append(data[i]).append(" ");
                }
            }
            if (finalText.toString().split(" ").length == 1) {
                return new String[] {};
            } else {
                return finalText.toString().split(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

    }
}
