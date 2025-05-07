package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String[] str = null;
            String s;
            int length = 0;
            String[] res = new String[length];
            StringBuilder builder = new StringBuilder();

            while ((s = reader.readLine()) != null) {
                String m = s.replaceAll("\\p{Punct}", "").toLowerCase(Locale.ROOT);
                str = m.split(" ");

                for (String word : str) {
                    if (word.toLowerCase(Locale.ROOT).charAt(0) == 'w') {
                        builder.append(word + ",");
                        length++;
                    }
                }
            }
            if (length != 0) {
                res = builder.toString().split(",");
                Arrays.sort(res);
                return res;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return new String[]{};
    }
}
