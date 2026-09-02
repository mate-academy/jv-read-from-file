package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder addWords = new StringBuilder();

        if (file.length() == 0) {
            return new String[]{};
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[]tempWords = line.toLowerCase().split(" ");
                for (String tempWord : tempWords) {
                    if (tempWord.charAt(0) == 'w') {
                        if (tempWord.contains(".") || tempWord.contains(",")
                                || tempWord.contains("?") || tempWord.contains("!")) {
                            addWords.append(tempWord.substring(0, tempWord.length() - 1))
                                    .append(" ");
                        } else {
                            addWords.append(tempWord).append(" ");
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file.: " + e);
        }
        if (addWords.length() > 0) {
            String[] finalArray = addWords.toString().split(" ");
            Arrays.sort(finalArray);
            return finalArray;
        }
        return new String[]{};
    }
}
