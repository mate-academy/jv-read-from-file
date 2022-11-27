package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        String outFile = stringBuilder.toString();
        if (outFile.length() == 0) {
            return new String[0];
        }
        String[] words = outFile.toLowerCase().split(" ");
        int lengthResult = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-z]", "");
            if (words[i].charAt(0) == 'w') {
                lengthResult++;
            }
        }
        String[] result = new String[lengthResult];
        if (lengthResult == 0) {
            return result;
        }
        int index = 0;
        for (String word : words) {
            if (word.charAt(0) == 'w') {
                result[index] = word;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
