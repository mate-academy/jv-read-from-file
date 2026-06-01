package core.basesyntax;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = reader.readLine();
            }

            String text = builder.toString().toLowerCase();
            String[] words = text.split("[\\s\\p{Punct}]+");
            int count = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    count ++;
                }
            }
            String[] result = new String[count];
            int index = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    result[index++] = word;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file ", e);
        }
        catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
