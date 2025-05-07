package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line.toLowerCase()).append(" ");
            }
            String[] words = builder.toString().split(" ");

            StringBuilder stringsWithW = new StringBuilder();
            for (String word : words) {
                if (word.startsWith("w")) {
                    stringsWithW.append(word).append(" ");
                }
            }

            if (stringsWithW.toString().isEmpty()) {
                return new String[]{};
            }

            String[] array = stringsWithW.toString().split("[ ,.?!]+");
            Arrays.sort(array);
            return array;
        } catch (IOException e) {
            throw new RuntimeException("Ooops...");
        }
    }
}
