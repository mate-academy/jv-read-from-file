package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                textFromFile.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File doesn`t exist\n", e);
        }
        if (!textFromFile.toString().isEmpty()) {
            for (String word : textFromFile.toString().split(" ")) {
                char[] wordChars = word.toLowerCase().toCharArray();
                StringBuilder temp = new StringBuilder();
                if (wordChars[0] == 'w') {
                    for (char symbol : wordChars) {
                        if (Character.isAlphabetic(symbol)) {
                            temp.append(symbol);
                        }
                    }
                    result.append(temp).append(" ");
                }
            }
        }
        String[] resultArray = result.toString().split(" ");
        Arrays.sort(resultArray);
        return (result.toString().isEmpty()) ? new String[0] : resultArray;
    }
}
