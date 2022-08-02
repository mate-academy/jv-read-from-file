package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Queue<String> queue = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    String[] split = line.split("\\W+");
                    for (String string : split) {
                        if (string.toLowerCase().charAt(0) == 'w') {
                            queue.add(string.toLowerCase());
                        }
                    }
                }
            } while (line != null);
        } catch (IOException e) {
            throw new RuntimeException("Is not possible to find the file");
        }
        String[] result = queue.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
