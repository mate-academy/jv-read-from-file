package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String withoutAtrt = stringBuilder.toString().replaceAll("[!?.,]", "")
                    .replaceAll("\n", " ");
            String[] textSplit = withoutAtrt.toLowerCase().split(" ");
            StringBuilder wordWithW = new StringBuilder();
            for (String word : textSplit) {
                char[] wordSplit = word.toCharArray();
                if (wordSplit.length == 0) {
                    break;
                }
                if (wordSplit[0] == 'w') {
                    wordWithW.append(word).append(' ');
                }
            }
            if (wordWithW.toString().toCharArray().length == 0) {
                return new String[0];
            }
            String[] wordsNeed = wordWithW.toString().split(" ");
            Arrays.sort(wordsNeed);
            return wordsNeed;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
