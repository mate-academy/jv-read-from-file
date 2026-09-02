package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        if (fileName == null || fileName.isEmpty()) {
            return new String[0];
        }

        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder finalWordsForArray = new StringBuilder();
        String[] finalValues;

        try {
            reader = new BufferedReader(new FileReader(file));
            String wordLine = reader.readLine();
            while (wordLine != null) {
                String[] arrayWordLine = wordLine.split(" ");
                for (String word:arrayWordLine) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        finalWordsForArray.append(word.toLowerCase().replaceAll("[\\p{Punct}]", ""))
                                .append(" ");
                    }
                }
                wordLine = reader.readLine();
            }
            if (finalWordsForArray.isEmpty()) {
                return new String[0];
            }
            finalValues = finalWordsForArray.toString().split(" ");
            Arrays.sort(finalValues);
        } catch (IOException e) {
            throw new RuntimeException("can't read file",e);
        }
        return finalValues;
    }
}
