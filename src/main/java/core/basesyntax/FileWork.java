package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String str = "";
        String[] finalArray = new String[0];
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                if (str.isEmpty()) {
                    break;
                } else {
                    String[] firstArr = str.toLowerCase().split("\\W+");
                    for (String s : firstArr) {
                        if (s.toLowerCase().startsWith("w")) {
                            builder.append(s).append(" ");
                        }
                    }
                    if (!builder.isEmpty()) {
                        finalArray = builder.toString().split(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Arrays.sort(finalArray);
        return finalArray;
    }
}
