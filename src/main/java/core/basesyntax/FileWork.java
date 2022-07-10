package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String [] arrayWords;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();

            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }

            if (stringBuilder.length() == 0) return new String[0];

            arrayWords =  stringBuilder.toString().replaceAll("[^A-Za-z ]", "").toLowerCase().split(" ");

            stringBuilder = new StringBuilder();
            for (String str : arrayWords) {
                if (str.charAt(0) == 'w') stringBuilder.append(str).append(" ");
            }

            if (stringBuilder.length() == 0) return new String[0];

            arrayWords = stringBuilder.toString().split(" ");
            Arrays.sort(arrayWords);
            return arrayWords;

        } catch (IOException e) {
            throw new RuntimeException("Can't open file", e);
        }
    }
}
