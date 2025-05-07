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
            String input = bufferedReader.readLine();
            int charCount = 0;
            while (input != null) {
                String[] inputArray = input.split(" ");
                for (String word: inputArray) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        charCount++;
                    }
                }
                input = bufferedReader.readLine();
            }
            String[] resultedArray = new String[charCount];
            bufferedReader = new BufferedReader(new FileReader(file));
            input = bufferedReader.readLine();
            int wordCount = 0;
            while (input != null) {
                String[] inputArray = input.split(" ");
                for (String word: inputArray) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        StringBuilder rigthWord = new StringBuilder();
                        for (int i = 0; i < word.length(); i++) {
                            if (Character.isLetter(word.charAt(i))) {
                                rigthWord.append(word.charAt(i));
                            }
                        }
                        resultedArray[wordCount] = rigthWord.toString().toLowerCase();
                        wordCount++;
                    }
                }
                input = bufferedReader.readLine();
            }
            Arrays.sort(resultedArray);
            return resultedArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
