package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String words = bufferedReader.readLine();
            while (words != null) {
                String[] split = words.split("\\W+");
                for (String splits : split) {
                    if (splits.charAt(0) == 'w' || splits.charAt(0) == 'W') {
                        stringBuilder.append(splits.toLowerCase()).append(" ");
                    }
                }
                words = bufferedReader.readLine();
            }
            String onlyW = stringBuilder.toString();
            String[] wordsW = onlyW.split(" ");
            if (wordsW.length == 1 && wordsW[0].isEmpty()) {
                return new String[0];
            }
            Arrays.sort(wordsW);
            return wordsW;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
