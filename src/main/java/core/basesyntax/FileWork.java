package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s\\p{Punct}]+");

                for(String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        FileWork processor = new FileWork();

        for (int i = 1; i <= 5; i++) {
            String fileName = "test" + i + ".txt";
            String[] result = processor.readFromFile(fileName);
            System.out.println(fileName + ": " + Arrays.toString(result));
        }
    }
}