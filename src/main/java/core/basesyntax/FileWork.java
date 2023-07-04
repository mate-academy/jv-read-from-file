package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] arrayResult = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileText = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                fileText.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            StringTokenizer stringTokenizer =
                    new StringTokenizer(fileText.toString(), " \t\n\r,.?!';");
            String[] words = new String[stringTokenizer.countTokens()];
            int counter = 0;
            while (stringTokenizer.hasMoreTokens()) {
                words[counter] = stringTokenizer.nextToken().toLowerCase();
                counter++;
            }
            StringBuilder wordsWithoutW = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith("w")) {
                    wordsWithoutW.append(words[i]).append(" ");
                }
            }
            if (wordsWithoutW.toString().length() == 0) {
                return new String[]{};
            }
            arrayResult = wordsWithoutW.toString().split(" ");
        } catch (IOException e) {
            throw new RuntimeException("File not read", e);
        }
        for (String s: arrayResult) {
            System.out.println(s);
        }
        Arrays.sort(arrayResult);
        return arrayResult;
    }
}
