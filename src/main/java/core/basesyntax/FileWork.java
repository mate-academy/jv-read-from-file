package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public static final char W = 'w';

    String[] readFromFile(String fileName) {

        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                result.append(nextLine);  //read an entire line as a String:
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Not Found Exception", e);
        } catch (IOException e) {
            throw new RuntimeException("No File", e);
        }
        String[] res = result.toString().toLowerCase().
                replaceAll("[^A-Za-zА-Яа-я ]", "").split(" ");

        return res.length == 0 ? new String[0] : Arrays
                .stream(res)
                .filter(word -> word.charAt(0) == W)
                .sorted()
                .toArray(String[]::new);
    }
}

