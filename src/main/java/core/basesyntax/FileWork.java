package core.basesyntax;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineReaded = bufferedReader.readLine();
            while (lineReaded != null) {
                String equalLine = lineReaded.toLowerCase().replaceAll("\\W+", " ");
                String[] words = equalLine.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].startsWith("w")) {
                        builder.append(words[i]).append(" ");
                    }
                }
                lineReaded = bufferedReader.readLine();
            }
            String[] result = builder.toString().split("\\s");
            Arrays.sort(result);
            System.out.println(Arrays.toString(result));
            return result.length == 1 ? new String[0] : result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not exist", e);
        } catch (IOException e) {
            throw new RuntimeException("Reading error form file", e);
        }
    }
}
