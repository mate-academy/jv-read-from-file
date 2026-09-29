package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }

        String content = stringBuilder.toString().toLowerCase();
        String[] tokens = content.split("[^a-zA-Z]+");

        int count = 0;
        for (String t : tokens) {
            if (!t.isEmpty() && t.startsWith("w")) {
                count++;
            }
        }

        String[] res = new String[count];
        int i = 0;

        for (String t : tokens) {
            if (!t.isEmpty() && t.startsWith("w")) {
                res[i++] = t;
            }
        }
        Arrays.sort(res);

        return res;
    }
}
