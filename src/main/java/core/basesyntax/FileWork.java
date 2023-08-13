package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {

    private static final String LETTER_W = "w";
    private static final int START_INDEX = 0;

    public String[] readFromFile(String fileName) {

        File myFile = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile))) {

            String word = bufferedReader.readLine();
            StringBuilder contentOfFile = new StringBuilder();

            while (word != null) {
                contentOfFile.append(word).append(" ");
                word = bufferedReader.readLine();
            }

            String[] splittedWords = contentOfFile.toString().split(" ");

            StringBuilder wordWithW = new StringBuilder();
            String tempWord;

            for (int i = START_INDEX; i < splittedWords.length; i++) {
                tempWord = splittedWords[i].toLowerCase();
                if (tempWord.startsWith(LETTER_W)) {
                    wordWithW.append(tempWord).append(" ");
                }
            }

            String[] splittedWordWithW = wordWithW.toString().split(" ");
            StringBuilder wordsWithoutSymbols = new StringBuilder();

            for (int i = START_INDEX; i < splittedWordWithW.length; i++) {
                wordsWithoutSymbols.append(splittedWordWithW[i].replaceAll("[^A-Za-z0-9 ]","")).append(" ");
            }

            String[] result = wordsWithoutSymbols.toString().split(" ");
            Arrays.sort(result);
            return result;

            } catch (IOException e) {
            throw new RuntimeException("can't read a file", e);
        }
    }
}
