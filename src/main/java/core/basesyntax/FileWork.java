package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
        String string = stringBuilder.toString();

        String[] split = string.split("\\W+");
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.toLowerCase().startsWith("w")) {
                lst.add(s.toLowerCase());
            }
        }
        lst.sort(Comparator.naturalOrder());
        return lst.toArray(new String[0]);
    }
}
