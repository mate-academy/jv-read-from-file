package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int ZERO_WORD_POSITION = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder listOfWStartingWords = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                fileLine = fileLine.toLowerCase();
                String[] splittedFileLine = fileLine.split(" ");
                for (int i = 0; i < splittedFileLine.length; i++) {
                    if ("w".equals(String.valueOf(splittedFileLine[i]
                            .charAt(ZERO_WORD_POSITION)))) {
                        splittedFileLine[i] = splittedFileLine[i].replaceAll("\\W", "");
                        listOfWStartingWords.append(splittedFileLine[i]).append(".");
                    }
                }
                fileLine = bufferedReader.readLine();
            }
            if (listOfWStartingWords.toString().equals("")) {
                return new String[]{};
            } else {
                String[] arrayOfWStartingWords = listOfWStartingWords.toString().split("\\.");
                Arrays.sort(arrayOfWStartingWords);
                return arrayOfWStartingWords;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
