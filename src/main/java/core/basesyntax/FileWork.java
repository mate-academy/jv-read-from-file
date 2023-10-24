package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int CHECKED_POSITION = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word: words) {
                    char firstChar = word.charAt(CHECKED_POSITION);
                    if (firstChar == 'w') {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append(',');
                        }
                        stringBuilder.append(word);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split(",");
        Arrays.sort(result);
        return result;
    }
}
