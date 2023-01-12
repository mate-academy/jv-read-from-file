package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final StringBuilder sb = new StringBuilder();
    private final StringBuilder sbTemp = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader((fileName)));
            String value = br.readLine();
            while (value != null) {
                sbTemp.append(value);
                String[] data = sbTemp.toString().toLowerCase().split(" ");
                for (String s : data) {
                    if (s.charAt(0) == 'w') {
                        s = s.replaceAll("[^a-z]", "");
                        sb.append(s).append(" ");
                    }
                }
                sbTemp.delete(0, sbTemp.length());
                value = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (sb.length() == 0) {
            return new String[0];
        } else {
            String[] result = sb.toString().split(" ");
            Arrays.sort(result);
            return result;
        }
    }
}
