package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //read text from file to stringBuilder
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int charInFile = bufferedReader.read();
            while (charInFile != -1) {
                stringBuilder.append((char) charInFile);
                charInFile = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        //if file is empty
        if (stringBuilder.length() == 0) {
            return new String[0];
        }

        //split text from the file to String by regex without spaces and punctuation
        String[] wordsFromFile = stringBuilder.toString().split("[^A-Za-z]+");

        //make all words lowercase, check is there the words starts with "w"
        // and move them to stringBuilder
        stringBuilder.setLength(0);
        for (int i = 0; i < wordsFromFile.length; i++) {
            wordsFromFile[i] = wordsFromFile[i].toLowerCase();
            if (startWithLetter(wordsFromFile[i])) {
                stringBuilder.append(wordsFromFile[i])
                        .append(" ");
            }
        }
        //if there are no words that start with "w" in the result
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        wordsFromFile = stringBuilder.toString().split(" ");
        //sort array of string with "w" naturally
        Arrays.sort(wordsFromFile);
        return wordsFromFile;
    }

    //check word start from the letter SPECIFIED_CHARACTER
    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
