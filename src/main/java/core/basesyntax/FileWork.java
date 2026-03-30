package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] results = new String[1000];
            String[] lastRes = new String[1000];
            int i = 0;
            int j = 0;
            String value = reader.readLine();
            while (value != null) {
                results[i] = value;
                i++;
                value = reader.readLine();
            }
            for (String result : results) {
                if (result != null) {
                    String[] tokens = result.split("\\W+");
                    for (String token : tokens) {
                        if (token.isEmpty()) {
                            continue;
                        }
                        String t = token.toLowerCase();
                        if (t.startsWith("w")) {
                            lastRes[j] = t;
                            j++;
                        }
                    }
                }
            }
            if (j == 0) {
                return new String[]{};
            }
            String [] finalRes = new String[j];
            System.arraycopy(lastRes, 0, finalRes, 0, finalRes.length);
            Arrays.sort(finalRes);
            return finalRes;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
