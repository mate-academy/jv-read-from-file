package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String [] readFromFile(String fileName) {
        try {
            String [] temp = Files.readString(Paths.get(fileName)).split("\\W+");
            StringBuilder sb = new StringBuilder();
            for (String s : temp) {
                if (s.startsWith("w") || s.startsWith("W")) {
                    sb.append(s);
                    sb.append(" ");
                }
            }
            String temp2 = sb.toString().toLowerCase();
            if (temp2.isEmpty()) {
                return new String[0];
            }
            String [] array2 = temp2.split(" ");
            Arrays.sort(array2);
            return array2;
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
    }
}
