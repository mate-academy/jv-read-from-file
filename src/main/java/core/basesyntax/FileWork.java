package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private BufferedReader reader;
    private StringBuilder builder1 = new StringBuilder();
    private StringBuilder builder2 = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                builder1.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            System.out.println(builder1.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file.");
        }
        String[] words = builder1.toString().split("\\W+");
        for (String word : words) {
            if (word.startsWith("w") || word.startsWith("W")) {
                builder2.append(word.toLowerCase().trim()).append(" ");
            }
        }
        if (builder2.toString().length() == 0) {
            return new String[0];
        } else {
            String[] resultArray = builder2.toString().split(" ");
            Arrays.sort(resultArray);
            for (String result : resultArray) {
                System.out.println(result);
            }
            System.out.println(builder2.toString());
            return resultArray;
        }
    }
}
