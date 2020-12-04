package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String [] str = new String[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                String [] resultWords = new String[0];
                return resultWords;
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String [] textString = stringBuilder.toString().split(" ");
            StringBuilder stringWords = new StringBuilder();
            boolean getEmplyResult = false;
            for (int i = 0; i < textString.length; i++) {
                if (textString[i].charAt(0) == 'w' || textString[i].charAt(0) == 'W') {
                    getEmplyResult = true;
                    if (!Character.isLetter(textString[i].charAt(textString[i].length() - 1))) {
                        stringWords.append(textString[i].toLowerCase()).deleteCharAt(stringWords
                                .length() - 1).append(" ");
                    } else {
                        stringWords.append(textString[i].toLowerCase()).append(" ");
                    }
                }
            }
            if (getEmplyResult) {
                String [] resultWords = stringWords.toString().split(" ");
                Arrays.sort(resultWords);
                return resultWords;
            }
            String [] resultWords = new String[0];
            return resultWords;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
