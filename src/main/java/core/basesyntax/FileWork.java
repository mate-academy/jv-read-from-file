package core.basesyntax;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String check;
        String[] strings;
        try {
            InputStream inputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<String> array = new ArrayList<>();
            while (bufferedReader.ready()) {
                check = (bufferedReader.readLine()).toLowerCase();
                String[] line = check.split(" ");
                for (String s : line) {
                    if (s.startsWith(SPECIFIED_CHARACTER)) {
                        array.add(s.replaceAll("\\p{Punct}", ""));
                    }
                }
            }
            inputStream.close();
            bufferedReader.close();
            Collections.sort(array);
            strings = array.toArray(new String[0]);
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
        return strings;
    }
}
