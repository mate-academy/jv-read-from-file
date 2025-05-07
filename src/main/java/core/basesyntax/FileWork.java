package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }

        String content = builder
                .toString()
                .toLowerCase()
                .replaceAll("\n", " ")
                .replaceAll("[^a-z ]","");

        if (content.length() == 0) {
            return new String[]{};
        }

        String[] splited = content.split(" ");
        int count = 0;
        for (String str : splited) {
            if (str.charAt(0) == 'w') {
                count++;
            }
        }
        String[] result = new String[count];
        int pos = 0;
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].charAt(0) == 'w') {
                result[pos] = splited[i];
                pos++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
