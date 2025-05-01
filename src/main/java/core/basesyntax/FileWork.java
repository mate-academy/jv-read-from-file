package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private ArrayList<String> list = new ArrayList<>();
    private String[] value;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] words = line.split(" ");
                saverWords(words);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            value[i] = list.get(i);
        }

        Arrays.sort(value);
        return value;

    }

    private boolean endsWithValue(String word) {
        return word.endsWith(",") || word.endsWith(".") || word.endsWith("!") || word.endsWith("?");
    }

    private boolean notWithValue(char value) {
        return value == '.' || value == ',' || value == '!' || value == '?';
    }

    private void saverWords(String[] words) {
        char[] word;
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().startsWith("w")) {
                if (!endsWithValue(words[i])) {
                    list.add(words[i].toLowerCase());
                } else {
                    word = words[i].toLowerCase().toCharArray();
                    for (int ii = 0; ii < word.length; ii++) {
                        if (!notWithValue(word[ii])) {
                            build.append(word[ii]);
                        }
                    }
                    list.add(build.toString());
                    build.setLength(0);
                }
            }
        }
    }
}
