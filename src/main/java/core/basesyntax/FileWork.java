package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            stringBuilder.append(value);
            while (value != null) {
                value = reader.readLine();
                stringBuilder.append(value).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String string = stringBuilder.toString();
        String[] strings = string.split("[^a-zA-Z]");
        List<String> list = new ArrayList<>();
        for (String word : strings) {
            if (word.startsWith("w") || word.startsWith("W")) {
                list.add(word.toLowerCase());
            }
        }
        Collections.sort(list);;
        return list.toArray(new String[0]);
    }
}
