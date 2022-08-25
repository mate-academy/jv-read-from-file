package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String lineFromDoc;
        int index = 0;
        int lastSymb = 0;
        String [] splitLines = new String[]{};
        String [] result = new String[]{};
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            lineFromDoc = bufferedReader.readLine();
            while (lineFromDoc != null) {
                splitLines = lineFromDoc.split(" ");
                for (int j = 0; j < splitLines.length; j++) {
                    if (splitLines[j].substring(0, 1).equals("w")
                            || splitLines[j].substring(0, 1).equals("W")) {
                        index += 1;
                        char [] symbol = splitLines[j].substring(splitLines[j].length() - 1)
                                .toCharArray();
                        lastSymb = symbol[0];
                        if ((lastSymb < 65) || (lastSymb > 90 && lastSymb < 97)
                                || (lastSymb > 122)) {
                            splitLines[j] = splitLines[j].substring(0, splitLines[j].length() - 1);
                        }
                        result = Arrays.copyOf(result, index);
                        result[index - 1] = splitLines[j].toLowerCase();
                    }
                }
                lineFromDoc = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + e);
        }
        Arrays.sort(result);
        return result;
    }
}
