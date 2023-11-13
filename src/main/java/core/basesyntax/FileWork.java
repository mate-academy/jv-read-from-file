package core.basesyntax;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {


    public String[] readFromFile(String fileName)  {
List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               line = line.replaceAll("[^a-zA-Z]", " ");
                String[] words = line.split("\\s+");


                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {

                     result.add(word.toLowerCase());
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(" Can`t read from file", e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
