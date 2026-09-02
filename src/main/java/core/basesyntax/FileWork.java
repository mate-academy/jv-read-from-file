package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String FIRST_CHAR = "w";

    public String[] readFromFile(String fileName) {
        //write your code here

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> list = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(" ").append(value);
                value = bufferedReader.readLine();
            }
            String [] words = stringBuilder.toString().split(REGEX);
            for (String word : words) {
                if (word.toLowerCase().startsWith(FIRST_CHAR)) {
                    list.add(word.toLowerCase());
                }
            }
            Collections.sort(list);
            return list.toArray((String[]::new));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
    }
}
