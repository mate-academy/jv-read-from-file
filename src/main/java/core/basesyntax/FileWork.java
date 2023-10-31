package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String str = "";
        String[] finalArray;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine().toLowerCase();
            }
            String[] firstArr = str.split("\\W+");
            for (String s : firstArr) {
                if (s.startsWith("w")) {
                    builder.append(s).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finalArray = builder.toString().split(" ");
        Arrays.sort(finalArray);
        return finalArray;
    }
}
