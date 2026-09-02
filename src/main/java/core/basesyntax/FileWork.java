package core.basesyntax;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        LinkedList<String> wordsWhitsW = new LinkedList<String>();
        List<String> strings;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (Exception e) {
            throw new RuntimeException("cant read file", e);
        }
        for (String word : strings) {
            String[] words = word.split(" ");
            for (String worde : words) {
                if (worde.toLowerCase().startsWith("w")) {
                    if (Character.isAlphabetic(worde.charAt(worde.length() - 1))) {
                        wordsWhitsW.add(worde.toLowerCase());
                    } else {
                        wordsWhitsW.add(worde.toLowerCase().substring(0, worde.length() - 1));
                    }
                }
            }

        }
        int size = wordsWhitsW.size();
        String[] stringArray = new String[size];
        for (int i = 0; i < size; i++) {
            stringArray[i] = wordsWhitsW.get(i);
        }
        Arrays.sort(stringArray);
        return stringArray;
    }
}
