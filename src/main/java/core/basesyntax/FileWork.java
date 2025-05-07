package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder allLine = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                allLine.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            String[] words = allLine.toString().replace("?","").replace("!","")
                    .replace(",", "").replace(".", "").replace("/","")
                    .replace(";","").replace(":", "").replace("-", "")
                    .replace(System.lineSeparator(), " ").toLowerCase().split(" ");
            int size = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].charAt(0) == 'w') {
                    size++;
                } else {
                    words[i] = null;
                }
            }
            int i = 0;
            String[] result = new String[size];
            for (String word : words) {
                if (word != null) {
                    result[i] = word;
                    i++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
