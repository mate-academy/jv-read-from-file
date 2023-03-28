package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                if (Character.isAlphabetic((char) content)) {
                    stringBuilder.append(Character.toLowerCase((char) content));
                } else {
                    stringBuilder.append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("IDK", e);
        }
        String[] splitWords = stringBuilder.toString().split(" ");
        int wordsCount = 0;
        for (String splitWord : splitWords) {
            if (splitWord.indexOf("w") == 0) {
                wordsCount++;
            }
        }
        String[] output = new String[wordsCount];
        for (int i = 0, j = 0; i < splitWords.length; i++) {
            if (splitWords[i].indexOf("w") == 0) {
                output[j] = splitWords[i];
                j++;
            }
        }
        Arrays.sort(output);
        return output;
    }
}
