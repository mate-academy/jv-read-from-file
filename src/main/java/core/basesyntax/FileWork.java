package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private final static String SPECIFIED_CHARACTER = "w";
    public String[] readFromFile(String fileName) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] words = builder.toString().toLowerCase().split("\\W+");
            List<String> wList = new ArrayList<>();
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    wList.add(word);
                }
            }
            Collections.sort(wList);
            return wList.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException("Can't reade from file!");
        }
    }
}
