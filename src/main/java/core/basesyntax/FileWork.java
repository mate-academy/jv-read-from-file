package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    
    public String[] readFromFile(String fileName) {
        String line;
        String word;
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] string = line.split("[ .,@#$%^?()!&]+");
                for (String n : string) {
                    word = n.toLowerCase();
                    if (startWithLetter(word)) {
                        lines.add(n.toLowerCase());
                        System.out.println(n);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lines.sort(Comparator.naturalOrder());
        return lines.toArray(new String[0]);
    }
    
    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
