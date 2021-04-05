package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String WORDS_SPLIT = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split(WORDS_SPLIT);
                for (String word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Reader not create!");
        }
        String sbString = stringBuilder.toString();
        String[] ary = new String[0];
        if (!sbString.isEmpty()) {
            ary = sbString.split(" ");
            Arrays.sort(ary);
        }
        return ary;
    }
}
