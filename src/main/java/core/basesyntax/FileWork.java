package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String stringLine;
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((stringLine = br.readLine()) != null) {
                for (String temp : stringLine.replaceAll("[^a-zA-Z ]", "")
                        .toLowerCase().split(" ")) {
                    if (String.valueOf(temp.charAt(0)).equals("w")) {
                        stringBuilder.append(temp).append(" ");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] resultString = stringBuilder.toString().split(" ");
        Arrays.sort(resultString);
        return resultString;
    }
}
