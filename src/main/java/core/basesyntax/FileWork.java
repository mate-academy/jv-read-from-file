package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list = new LinkedList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                var words = line.split("\\W+");
                for (var word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        list.add(word.toLowerCase());
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something goes wrong");
        }
        Collections.sort(list);
        String[] results = new String[list.size()];
        list.toArray(results);
        return results;
    }
}
