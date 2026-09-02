package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            String reader = bufferedReader.readLine();
            while (reader != null) {
                line += reader + " ";
                reader = bufferedReader.readLine();
            }
            if (line.isEmpty()) {
                return new String[]{};
            }
            String[] words = line.split("\\W+");
            String[] tmp = new String[words.length];
            int index = 0;
            for (String word : words) {
                if (word.toLowerCase().charAt(0) == 'w') {
                    tmp[index] = word.toLowerCase();
                    index++;
                }
            }
            if (tmp.length == 0) {
                return new String[]{};
            }
            String[] result = new String[index];
            for (int i = 0; i < result.length; i++) {
                result[i] = tmp[i];
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
    }
}
