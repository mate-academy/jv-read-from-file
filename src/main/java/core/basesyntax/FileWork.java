package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String LINE_SEPARATOR = " ";
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String WORDS_SPLITTER = ",";

    public String[] readFromFile(String fileName) {
        final String[] splitLine = getStrings(fileName);
        StringBuilder connectedLine = new StringBuilder();

        for (String string : splitLine) {
            String word = string.toLowerCase();
            if (!word.isEmpty() && word.charAt(0) == SPECIFIED_CHARACTER) {
                connectedLine.append(word).append(WORDS_SPLITTER);
            }
        }
        String[] d = connectedLine.toString().split(WORDS_SPLITTER);
        Arrays.sort(d);
        return (connectedLine.isEmpty() ? new String[0] : d);
    }

    private static String[] getStrings(String fileName) {
        StringBuilder readFromFile = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                readFromFile.append(LINE_SEPARATOR).append(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can`t find the file", e);
        }
        return readFromFile.toString().split("\\W+");
    }
}
