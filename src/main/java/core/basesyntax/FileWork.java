package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String text = reader.readLine();
            StringBuilder wordsStartingWithW = new StringBuilder();
            if (text == null) {
                return new String[0];
            } else {
                while (text != null) {
                    text = text.toLowerCase();
                    String[] split = text.split("\\W+");
                    for (String s : split) {
                        if (s.startsWith("w")) {
                            wordsStartingWithW.append(s + " ");
                        }
                    }
                    text = reader.readLine();
                }
                String result = wordsStartingWithW.toString();
                if (result.isEmpty()) {
                    return new String[0];
                } else {
                    return sortStringArray(result.split(" "));
                }
            }
        } catch (IOException e) {
            System.out.println("An exception has occured");
            return null;
        }
    }

    public String[] sortStringArray(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                char[] comparedWord1 = array[i].toCharArray();
                char[] comparedWord2 = array[j].toCharArray();
                int c = 0;
                do {
                    if (comparedWord1[c] > comparedWord2[c]) {
                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        break;
                    } else if (comparedWord1[c] < comparedWord2[c]) {
                        break;
                    }
                    ++c;
                } while (c < comparedWord1.length && c < comparedWord2.length);
            }
        }
        return array;
    }
}
