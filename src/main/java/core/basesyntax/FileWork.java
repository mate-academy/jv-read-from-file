package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHAR_W = "w";

    public String[] readFromFile(String fileName) {
        String[] array;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String words = reader.readLine();
            StringBuilder wordsBuilder = new StringBuilder();
            if (words == null || words.length() == 0) {
                return new String[0];
            }
            while (words != null) {
                wordsBuilder.append(words).append(" ");
                words = reader.readLine();
            }
            String[] wordsArray;
            wordsArray = wordsBuilder.toString().split("\\W+");
            int firstIndex;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < wordsArray.length; i++) {
                String separatedWord = wordsArray[i].toString().toLowerCase();
                firstIndex = separatedWord.indexOf(CHAR_W);
                if (firstIndex == 0) {
                    builder.append(separatedWord).append(" ");
                }
            }
            array = builder.toString().split(" ");
            Arrays.sort(array);
            String noMatchingWords = builder.toString();
            if (noMatchingWords.equals("")) {
                return new String[0];
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Can't close resources", e);
            }
        }
        return array;
    }
}
