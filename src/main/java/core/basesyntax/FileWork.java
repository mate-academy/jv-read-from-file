package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int INITIAL_ARRAY_SIZE = 10;
    //Starting size for array.
    private static final int GROW_VALUE = 2;
    //Grow factor for array when needed.
    private static final int ARRAY_COPY_SRC_POSITION = 0;
    //Source position constant for copy array.
    private static final int ARRAY_COPY_DEST_POSITION = 0;
    //Destination position constant for copy array.

    public String[] readFromFile(String fileName) {
        String text;
        String[] wordsWithW = new String[INITIAL_ARRAY_SIZE];
        int count = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((text = bufferedReader.readLine()) != null) {
                text = text.replaceAll("[^\\w\\s]", "");
                //Remove punctuation.
                String[] splitLine = text.toLowerCase().split(" ");
                //Split clear text into words.

                for (String word : splitLine) {
                    if (!word.isEmpty() && word.charAt(0) == 'w') {
                        if (count >= wordsWithW.length) {
                            //Increase array length if count exceeds.
                            arrayGrow(wordsWithW, count);
                        }
                        wordsWithW[count] = word;
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + fileName, e);
        }
        String[] finalArr = new String[count]; //Create new array with required size.
        System.arraycopy(wordsWithW, ARRAY_COPY_SRC_POSITION,
                finalArr, ARRAY_COPY_DEST_POSITION, count);
        Arrays.sort(finalArr); //Sort array in alphabet order.
        return finalArr;
    }

    private void arrayGrow(String[] originalArr, int currentCount) {
        //Create new array with a larger size.
        int newSize = originalArr.length * GROW_VALUE;
        String[] newArr = new String[newSize];
        System.arraycopy(originalArr, ARRAY_COPY_SRC_POSITION,
                newArr, ARRAY_COPY_DEST_POSITION, currentCount);
    }
}
