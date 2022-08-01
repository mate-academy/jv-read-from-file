package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private ArrayList<String> words = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        FileInputStream filein;
        try {
            filein = new FileInputStream(fileName);
            if (filein.available() == 0) {
                return new String[0];
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(filein));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] strings = line.split(" ");
                    for (String string : strings) {
                        string = string.toLowerCase();
                        if (string.charAt(0) == 'w') {
                            string = string.replaceAll("[,.;!?]", "");
                            words.add(string.toLowerCase());
                        }
                    }
                }
                filein.close();
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(words);
        String[] strings = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            strings[i] = words.get(i);
        }
        return strings;
    }
}
