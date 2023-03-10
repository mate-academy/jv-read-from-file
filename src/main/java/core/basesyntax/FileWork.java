package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";
    public static final String SPECIFIED_LOWER_CHARACTER = "W";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String fileToString = stringBuilder.toString();
            String[] finalResult = fileToString.split("\\W+");
            StringBuilder result = new StringBuilder();
            for (String word : finalResult) {
                if (word.startsWith(SPECIFIED_CHARACTER)
                        || word.startsWith(SPECIFIED_LOWER_CHARACTER)) {
                    result.append(word.toLowerCase()).append(" ");
                }
            }
            if (result.length() == 0) {
                return new String[0];
            } else {
                String[] resultWords = result.toString().split(" ");
                String temp;
                for (int i = 0; i < resultWords.length; i++) {
                    for (int j = i + 1; j < resultWords.length; j++) {
                        if (resultWords[i].compareTo(resultWords[j]) > 0) {
                            temp = resultWords[i];
                            resultWords[i] = resultWords[j];
                            resultWords[j] = temp;
                        }
                    }
                }
                return resultWords;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
