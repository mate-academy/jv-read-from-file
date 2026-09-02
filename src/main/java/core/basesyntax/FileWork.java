package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder string = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                string.append(value).append(" ");
                value = reader.readLine();
            }
            String str = string.toString();
            if (str.isEmpty()) {
                return new String[0];
            }
            str = str.toLowerCase();
            String[] arr = str.split(" ");
            int count = 0;
            for (String s : arr) {
                char[] c = s.toCharArray();
                if (c[0] == 'w') {
                    count++;
                }
            }
            String[] result = new String[count];
            int f = 0;
            for (String s : arr) {
                s = s.replace(".", "");
                s = s.replace(",", "");
                s = s.replace("?", "");
                s = s.replace("!", "");
                char[] c = s.toCharArray();
                if (c[0] == 'w') {
                    result[f] = s;
                    f++;
                }
            }
            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
