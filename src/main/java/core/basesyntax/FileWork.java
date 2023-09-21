package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FileWork {
    public static final String SPECIFIC_CHAR = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
      //  return null;
        File file = new File(fileName);
        String readFrom = null;
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null){
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't find the file, or read file");
        }
        readFrom = builder.toString();

        if (readFrom.isEmpty()) {
            return new String[0];
        }

        ArrayList<String> wordStartWithW = new ArrayList<>();

        String [] readFromFile = readFrom.split("\\W+");

        for (String word : readFromFile) {
            word = word.toLowerCase();
            if (word.startsWith(SPECIFIC_CHAR)) {
                wordStartWithW.add(word);
            }
        }
        Collections.sort(wordStartWithW);

        return wordStartWithW.toArray(new String[0]);

    }
}
