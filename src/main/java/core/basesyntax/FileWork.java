package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private String[] results = new String[0];

    public String[] readFromFile(String fileName) {
        File newFile = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));) {
            StringBuilder sb = new StringBuilder();
            String element = bufferedReader.readLine();

            while (element != null) {
                sb.append(element).append(System.lineSeparator());
                element = bufferedReader.readLine();
            }

            if (sb.length() == 0) {
                return results;
            }

            String content = sb.toString();
            String[] words = content.split("\\s+");

            StringBuilder results = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                char[] symbol = words[i].toCharArray();
                if (symbol[0] == 'w' || symbol[0] == 'W') {
                    words[i] = words[i].toLowerCase();
                    results.append(words[i].substring(1)).append(' ');
                }
            }

            if (results.length() == 0) {
                return new String[0];
            }

            String result = results.toString();
            this.results = result.split(" ");
            Arrays.sort(this.results);

            for (int i = 0; i < this.results.length; i++) {
                this.results[i] = "w" + this.results[i].replaceAll("[^a-zA-Z]+$", "");
            }

            return this.results;
        } catch (IOException e) {
            throw new RuntimeException("Can`t exist file");
        }
    }
}
