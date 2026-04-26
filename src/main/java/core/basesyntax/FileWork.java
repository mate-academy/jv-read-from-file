package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(" ").append(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        char[] worlds;
        String[] data = stringBuilder.toString().toLowerCase().split(" ");
        int counterW = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].startsWith("w")) {
                data[i] = data[i].replaceAll("[\\p{Punct}]+$", "");
                counterW++;
            }
        }
        if (counterW == 0) {
            return new String[0];
        }
        String[] result = new String[counterW];
        for (String world: data) {
            if (world.startsWith("w")) {
                result[counterW - 1] = world;
                counterW--;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
