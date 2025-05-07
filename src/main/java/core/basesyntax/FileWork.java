package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                value = value.toLowerCase();
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("No such file");
        }
        String[] split = stringBuilder.toString().split("\\W+");
        stringBuilder = new StringBuilder();
        for (String word : split) {
            if (word.startsWith("w")) {
                stringBuilder.append(word).append(" ");
            }
        }
        split = stringBuilder.toString().trim().split(" ");
        Arrays.sort(split);
        System.out.println(Arrays.asList(split));
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        return split;
    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        fileWork.readFromFile("test5");
    }
}
