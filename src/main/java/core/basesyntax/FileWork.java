package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] checkEmpty = new String[0];
        File file = new File(fileName);

        if (file.length() == 0) {
            return checkEmpty;
        }

        StringBuilder selectWords = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            Pattern pattern = Pattern.compile("[ ,.!?:;]");

            while (line != null) {
                line = line.toLowerCase();
                String[] arrayOfWordsOfLine = pattern.split(line);
                for (String s : arrayOfWordsOfLine) {
                    if (s.startsWith("w")) {
                        selectWords.append(s).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't found the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] arrayOfSelectWords = selectWords.toString().split(" ");

        Arrays.sort(arrayOfSelectWords);

        return selectWords.length() != 0 ? arrayOfSelectWords : checkEmpty;
    }
}
