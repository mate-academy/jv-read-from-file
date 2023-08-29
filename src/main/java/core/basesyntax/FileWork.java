package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        int index = 0;
        String[] returnArray;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return returnArray = new String[0];
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] splitFile = builder.toString().toLowerCase().split("\\W ");
            for (String word : splitFile) {
                String[] splitFile1 = word.split(" ");
                for (String word1 : splitFile1) {
                    char charAtIndexOne = word1.charAt(0);
                    if (charAtIndexOne == 'w') {
                        index++;
                    }
                }
            }
            returnArray = new String[index];
            int i = 0;
            for (String word : splitFile) {
                String[] splitFile1 = word.split(" ");
                for (String word1 : splitFile1) {
                    char charAtIndexOne = word1.charAt(0);
                    if (charAtIndexOne == 'w') {
                        returnArray[i++] = word1;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Arrays.sort(returnArray);
        return returnArray;
    }
}



