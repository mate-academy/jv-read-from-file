package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final StringBuilder fileLinesSplitter = new StringBuilder();
    private static final StringBuilder wordWithWSplitter = new StringBuilder();

    public String[] readFromFile(String fileName) {
        //write your code here
        File myFile = new File(fileName);
        try {
            if (myFile.length() == 0) {
                return new String[0];
            }
            for (String word : splitFileLines(myFile)) {
                word = word.toLowerCase();
                if (word.startsWith("w")) {
                    wordWithWSplitter.append(word).append(" ");
                }
            }

            String[] resultList = wordWithWSplitter.toString().split(" ");
            Arrays.sort(resultList);

            for (int i = 0; i < resultList.length; i++) {
                switch (resultList[i].charAt(resultList[i].length() - 1)) {
                    case '.', ',', '!', '?':
                        resultList[i] = resultList[i].substring(0, resultList[i].length() - 1);
                        break;
                }
            }

            return resultList;
        } catch (IndexOutOfBoundsException e) {
            return new String[0];
        }
    }

    private String[] splitFileLines(File myFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String lineReader = reader.readLine();
            while (lineReader != null && !lineReader.isEmpty()) {
                fileLinesSplitter.append(" ").append(lineReader);
                lineReader = reader.readLine();
            }
            return fileLinesSplitter.toString().split(" ");
        } catch (IOException e) {
            return new String[0];
        }
    }
}
