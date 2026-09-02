package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        } else {
            String data = stringBuilder.toString().toLowerCase()
                    .replace("\n", " ").replaceAll("\\p{Punct}", "");
            String[] words = data.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int a = 0; a < words.length; a++) {
                char first = words[a].charAt(0);
                if (first == 'w') {
                    builder.append(words[a]).append(" ");
                }
            }
            if (builder.length() == 0) {
                return new String[]{};
            } else {
                String newData = builder.toString();
                String[] answer = newData.split(" ");
                Arrays.sort(answer);
                return answer;
            }
        }
    }
}
