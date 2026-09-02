package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> res = new ArrayList<>();
        try {
            BufferedReader senteces = new BufferedReader(new FileReader(fileName));
            String sentence = senteces.readLine();

            while (sentence != null) {
                for (String word : sentence.split("\\W+")) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        res.add(word.toLowerCase());
                    }
                }
                sentence = senteces.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(res);

        return res.size() > 0
                ? String.join(" ", res).split(" ") : new String[0];
    }
}
