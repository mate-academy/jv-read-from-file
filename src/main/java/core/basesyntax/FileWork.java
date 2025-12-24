package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> list = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    return new String[]{};
                }
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        list.add(word);
                    }
                }
            }
            return list.stream().sorted().toArray(String[]::new);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cant read the file" + e);
        } catch (IOException e) {
            throw new RuntimeException("Empty file" + e);
        }
    }
}
