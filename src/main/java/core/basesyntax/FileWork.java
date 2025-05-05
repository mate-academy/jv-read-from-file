package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WHITESPACE = " ";
    private static final char WORD_STARTING_CHAR = 'W';
    private static final char WORD_STARTING_CHAR_LOWER_CASE = 'w';
    private static final int EMPTY_ARRAY_INDEX = 0;

    public String[] readFromFile(String fileName) {
        int counter = 0;
        //write your code here
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String message = input.readLine();

            if (message == null) {
                return new String[EMPTY_ARRAY_INDEX];
            }

            while (message != null) {
                builder.append(message).append(WHITESPACE);
                message = input.readLine();
            }

            String[] messageSplit = builder.toString().split("\\W+");
            for (String messageSplitArray : messageSplit) {
                if (messageSplitArray.indexOf(WORD_STARTING_CHAR) == 0
                        || messageSplitArray.indexOf(WORD_STARTING_CHAR_LOWER_CASE) == 0) {
                    counter++;
                }
            }
            String[] readFromFileOutput = new String[counter];
            counter = 0;
            for (String messageSplitArray : messageSplit) {
                if (messageSplitArray.indexOf(WORD_STARTING_CHAR) == 0
                        || messageSplitArray.indexOf(WORD_STARTING_CHAR_LOWER_CASE) == 0) {
                    counter++;
                    readFromFileOutput[counter - 1] = messageSplitArray.toLowerCase();
                }
            }
            Arrays.sort(readFromFileOutput);
            return readFromFileOutput;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
