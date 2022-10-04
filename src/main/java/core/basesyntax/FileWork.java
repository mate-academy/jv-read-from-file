package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String FILTER = "\\W+";
    private static final String CHECK_FIRST_INDEX = "w";

    public String[] readFromFile(String fileName) {
        String [] array;
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        if (new File(fileName).length() == 0) {
            return new String[0];
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                builder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read file " + e);
        }
        array = builder.toString().split(FILTER);

        for (String str : array) {
            String s = String.valueOf(str.charAt(0)).toLowerCase();
            if (s.equals(CHECK_FIRST_INDEX)) {
                list.add(str.toLowerCase());
            }
        }
        Collections.sort(list);

        return list.toArray(new String[0]);
    }
}
