package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            StringBuilder stringBuilder = new StringBuilder();
            String[] splits = builder.toString().split("\\W+");
            for (int i = 0; i < splits.length; i++) {
                if (splits[i].toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(splits[i]).append(" ");
                }
            }
            String someNew = stringBuilder.toString().toLowerCase();
            if (someNew.length() == 0) {
                return new String[]{};
            } else {
                String[] a = someNew.split(" ");
                Arrays.sort(a);
                return a;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read  file",e);
        }
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
