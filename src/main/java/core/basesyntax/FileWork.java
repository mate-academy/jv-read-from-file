package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        String result = "";

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            StringBuilder strBuilder = new StringBuilder();
            String value = bufReader.readLine();

            while (value != null) {
                String[] words = value.split(" ");
                for (String word : words) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        strBuilder.append(word).append(" ");
                        result = strBuilder.toString().toLowerCase()
                                .replaceAll("[.,;?!]", "");
                    }
                }
                value = bufReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + fileName, e);
        }
        if (result.length() > 0) {
            String[] resArray = result.split(" ");
            Arrays.sort(resArray);
            return resArray;
        } else {
            return new String[0];
        }
    }
}
