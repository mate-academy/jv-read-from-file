package core.basesyntax;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName){
        File file = new File(fileName);
        List<String> wordsStartingWithW = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader (file))){
            String line = bufferedReader.readLine();

            if (line != null) {
                String[] words = line.split("\\s+");
                for (String word: words) {
                    word = word.toLowerCase();
                    if(word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordsStartingWithW.toArray(new String[0]);
    }
}
