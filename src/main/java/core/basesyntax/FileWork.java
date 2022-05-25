package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String START_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder str = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] strarray = value.toLowerCase().split(" ");
                for (String word : strarray) {
                    if (word.startsWith(START_CHAR)) {
                        str.append(word).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (str.toString().isEmpty()) {
            return new String[0];
        }
        String strm = str.toString().replaceAll("\\p{P}", "");
        String[] arraystr = strm.split(" ");
        Arrays.sort(arraystr);
        return arraystr;
    }
}
