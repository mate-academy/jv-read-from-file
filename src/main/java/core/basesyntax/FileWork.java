package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String fromFileString = stringBuilder.toString();
            if (fromFileString.isEmpty()) {
                return new String[]{};
            }
            return readFromString(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("can't read file");
        }
    }

    public static String[] readFromString(String input) {
        String[] words = input.toLowerCase().split("\\W+");
        String resultString = "";
        for (String word: words) {
            if (word.charAt(0) == 'w') {
                resultString += word + " ";
            }
        }
        if (resultString.isEmpty()) {
            return new String[]{};
        }
        String[] resultArray = resultString.split("\\W+");
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = i + 1; j < resultArray.length; j++) {
                if (resultArray[i].compareTo(resultArray[j]) > 0) {
                    String temp = resultArray[i];
                    resultArray[i] = resultArray[j];
                    resultArray[j] = temp;
                }
            }
        }
        return resultArray;
    }
}

