package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {

    public static void main(String[] args) {
        readFromFile("test1");
    }

    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        if (file.length() == 0) {
            return new String[0];
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file");
        }

        String[] splitContent = builder.toString().toLowerCase().split("\\W+");
        int counter = 0;
        for (String word : splitContent) {
            if (word.charAt(0) == 'w') {
                counter++;
            }
        }
        if (counter == 0) {
            return new String[0];
        }
        String[] result = new String[counter];
        counter = 0;
        for (String word : splitContent) {
            if (word.charAt(0) == 'w') {
                result[counter] = word;
                counter++;
            }
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        return result;
    }
}
