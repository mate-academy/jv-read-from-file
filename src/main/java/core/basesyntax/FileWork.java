package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] data = line.toLowerCase().split("[,.?! ]");
                for (String element : data) {
                    if (element.startsWith("w")) {
                        builder.append(element).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
            if (builder.length() == 0) {
                return new String[0];
            } else {
                String[] result = builder.toString().split(" ");
                Arrays.sort(result);
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println("Error closing the BufferedReader: " + e.getMessage());
                }
            }
        }
    }
}