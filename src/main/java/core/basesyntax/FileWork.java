package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder contentBuilder = new StringBuilder();
            int value = bufferedReader.read();

            while (value != -1) {
                contentBuilder.append((char) value);
                value = bufferedReader.read();
            }

            String string = contentBuilder.toString();

            String[] words = string.split("[\\s\\p{Punct}]+");

            StringBuilder resultBuilder = new StringBuilder();

            for (String word: words) {
                if (!word.isEmpty() && (word.startsWith("w") || word.startsWith("W"))) {
                    resultBuilder.append(word.toLowerCase()).append(" ");
                }
            }

            String result = resultBuilder.toString();

            if (result.length() == 0) {
                return new String[0];
            } else {
                String[] sortedResult = result.toString().split(" ");

                for (int i = 0; i < sortedResult.length - 1; i++) {
                    for (int j = i + 1; j < sortedResult.length; j++) {
                        if (sortedResult[i].compareTo(sortedResult[j]) > 0) {
                            String temp = sortedResult[i];
                            sortedResult[i] = sortedResult[j];
                            sortedResult[j] = temp;
                        }
                    }
                }

                return sortedResult;
            }
        } catch (IOException e) {
            StringBuilder exceptionBuilder = new StringBuilder();
            exceptionBuilder.append("Can't read ").append(fileName).append(" file.");
            String exceptionMessage = exceptionBuilder.toString();

            throw new RuntimeException(exceptionMessage, e);
        }
    }
}
