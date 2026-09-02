package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_LETTER = 0;

    public String[] readFromFile(String fileName) {
        ArrayList<String> stringsStatFromW = new ArrayList<>();
        String[] arrayOfStrings = {};
        try {
            String stringFromFile = new String(Files.readAllBytes(Paths.get(fileName)));
            stringFromFile = stringFromFile.replaceAll("\n", " ").replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase();
            if (stringFromFile.length() == 0) {

                return (arrayOfStrings);
            } else {
                String[] words = stringFromFile.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].charAt(FIRST_LETTER) == 'w') {

                        stringsStatFromW.add(words[i]);
                    }
                }
            }
            arrayOfStrings = stringsStatFromW.toArray(new String[stringsStatFromW.size()]);
            Arrays.sort(arrayOfStrings);
            return arrayOfStrings;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
