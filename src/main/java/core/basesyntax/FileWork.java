package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    private static final int END_OF_FILE = -1;
    private static final String LETTER_WORD_START = "w";
    private static final String EXCEPTION_TEXT = "Can't read file";
    private static final String LINE_SEPARATOR = " ";
    private static final int LENGTH_EMPTY_ARRAY = 0;
    private static final int LENGTH_EMPTY_STRING = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        BufferedReader bufferedReader;
        StringBuilder result = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                int c = bufferedReader.read();
                if (c == END_OF_FILE) break;
                String fileLine = bufferedReader.readLine();
                fileLine = ((char) c + fileLine).toLowerCase();
                String[] wordsFromLine = fileLine.split(LINE_SEPARATOR);
                for (String word : wordsFromLine) {
                    if (word.startsWith(LETTER_WORD_START)) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < word.length(); i++) {
                            if (Character.isLetterOrDigit(word.charAt(i)))
                                sb.append(word.charAt(i));
                        }
                        word = sb.toString();
                        result.append(word).append(LINE_SEPARATOR);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_TEXT, e);
        }
        String[] resultArray = result.toString().split(LINE_SEPARATOR);
        Arrays.sort(resultArray);
        return result.toString().length() > LENGTH_EMPTY_STRING ? resultArray : new String[LENGTH_EMPTY_ARRAY];
    }
}
