package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder result = new StringBuilder("");
        try {
            String sent = Files.readString(Paths.get(fileName));
            if (sent.isEmpty()) {
                return new String[] {};
            }
            sent = sent.replaceAll("[!?,.:;]", "");
            System.out.println(sent);
            for (String word : sent.split(" ")) {
                word = word.toLowerCase();
                if (word.toCharArray()[0] == 'w') {
                    result.append(word).append("/");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (result.isEmpty()) {
            return new String[] {};
        }
        String[] sortedArray = result.toString().split("[\\s/]+");
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = sortedArray[i].trim();
        }
        Arrays.sort(sortedArray);
        return sortedArray;

    }
}
