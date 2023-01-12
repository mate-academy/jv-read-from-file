package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        int counter = 0;
        File file = new File(fileName);
        List<String> strings;
        String[] strings1 = new String[1_000];
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("couldn't read file", e);
        }

        for (int i = 0, b = 0; i < strings.size(); i++) {
            String[] tmpArray = strings.get(i).split(" ");
            for (String q : tmpArray) {
                if (q.startsWith("w") || q.startsWith("W")) {
                    strings1[b] = q.toLowerCase();
                    counter++;
                    b++;
                }
            }
        }
        if (counter == 0) {
            return new String[]{};
        }
        String[] strings2 = new String[counter];
        counter = 0;
        for (String i : strings1) {
            if (i != null) {
                strings2[counter] = i;
                counter++;
            }
        }
        for (int i = 0; i < strings2.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] tmpArray = strings2[i].toCharArray();
            for (char q : tmpArray) {
                int ascii = q;
                if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                    stringBuilder.append(q);
                }
            }
            strings2[i] = stringBuilder.toString();
        }
        for (int q = 0; q < strings2.length; q++) {
            for (int i = 0; i < strings2.length - 1; i++) {
                if (strings2[i].compareTo(strings2[i + 1]) > 0) {
                    String tmp = strings2[i];
                    strings2[i] = strings2[i + 1];
                    strings2[i + 1] = tmp;

                }
            }
        }
        return strings2;
    }
}
