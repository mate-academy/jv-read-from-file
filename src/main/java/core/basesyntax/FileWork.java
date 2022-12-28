package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FileWork {
    static final String SPECIFIED_CHARACTER = "w";
    static final String SECOND_SPECIFIED_CHARACTER = "W";
    static final int ZERO_INDEX = 0;
    static final int FIRST_INDEX = 1;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readLine = reader.readLine();
            while (readLine != null) {
                String[] split = readLine.split("\\W+");
                for (String wordFromSplit : split) {
                    String firstLetter = wordFromSplit.substring(ZERO_INDEX, FIRST_INDEX);
                    if (firstLetter.equals(SPECIFIED_CHARACTER)
                            || firstLetter.equals(SECOND_SPECIFIED_CHARACTER)) {
                        String secondPartOfWord = wordFromSplit.substring(FIRST_INDEX);
                        stringBuilder.append(firstLetter)
                                .append(secondPartOfWord)
                                .append(" ");
                    }
                }
                readLine = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] sortedWords = toStringArray(stringBuilder);
        return sortedWords;
    }
    private String[] toStringArray(StringBuilder stringBuilder) {
        int i = 0;
        String toString = stringBuilder.toString().toLowerCase();
        StringTokenizer stringTokenizer = new StringTokenizer(toString);
        String[] sortedWords = new String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreTokens()) {
            sortedWords[i] = stringTokenizer.nextToken();
            i++;
        }
        Arrays.sort(sortedWords);
        return sortedWords;
    }
}
