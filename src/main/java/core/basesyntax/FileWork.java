package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String inputString = bufferedReader.readLine();
            int arrayLength = 0;
            while (inputString != null) {
                String[] inputArray = inputString.split(" ");
                for (String word : inputArray) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        arrayLength++;
                    }
                }
                inputString = bufferedReader.readLine();
            }
            String[] resultArray = new String[arrayLength];
            bufferedReader = new BufferedReader(new FileReader(file));
            inputString = bufferedReader.readLine();
            int wordCount = 0;
            while (inputString != null) {
                String[] inputArray = inputString.split(" ");
                for (String word : inputArray) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        StringBuilder resultWords = new StringBuilder();
                        for (int i = 0; i < word.length(); i++) {
                            if (Character.isLetter(word.charAt(i))) {
                                resultWords.append(word.charAt(i));
                            }
                        }
                        resultArray[wordCount] = resultWords.toString().toLowerCase();
                        wordCount++;
                    }
                }
                inputString = bufferedReader.readLine();
            }
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
