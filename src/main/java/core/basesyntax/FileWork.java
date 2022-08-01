package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();
        String line;
        String[] wordsWithW;
        String[] arrayOfW;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            while ((line = bufferedReader.readLine()) != null) {

                wordsWithW = line.split(" ");
                for (String s : wordsWithW) {
                    if ((s.charAt(0) == 'w') || (s.charAt(0) == 'W')) {
                        builder.append(s.toLowerCase()).append(" ");
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file");
        }
        String string = builder.toString().toLowerCase();
        if (string.equals("")) {
            return new String[0];
        }
        arrayOfW = string.split("\\W+");
        Arrays.sort(arrayOfW);
        return arrayOfW;
    }
}

