package core.basesyntax;

import java.io.FileInputStream;
import java.io.IOException;

public class FileWork {
    public static String[] readFromFile(String fileName) throws IOException {
        if (fileName.isEmpty()) {
            return new String[0];
        }
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String content = sb.toString();

        String nw = content.replaceAll("[.!/?*']", "").toLowerCase();
        String n = nw.replaceAll("[\n\r]", " no ").toLowerCase();
        String[] splt = n.split(" ");
        int amountFound = 0;

        for (String word : splt) {
            if (word.startsWith("w")) { //check if word starts with searchWord
                amountFound++;
            }
        }
        if (amountFound == 0) {
            return new String[0];
        }
        int u = 0;
        String[] s = new String[amountFound];
        for (String string : splt) {
            if (string.startsWith("w")) {
                s[u] = string;
                u++;
            }
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].compareTo(s[j]) > 0) {
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        return s;
    }
}
