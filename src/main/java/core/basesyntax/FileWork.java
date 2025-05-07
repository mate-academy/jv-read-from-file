package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            ArrayList<String> list = new ArrayList<>(Arrays.asList(stringBuilder
                    .toString().toLowerCase()
                    .replaceAll("\n", " ")
                    .replaceAll("[!?.]", "").split(" ")));
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).startsWith("w")) {
                    list.remove(i);
                    i--;
                }
            }
            String[] resultString = new String[list.size()];
            Collections.sort(list);
            for (int i = 0; i < resultString.length;i++) {
                resultString[i] = list.get(i);
            }
            return resultString;
        } catch (IOException e) {
            throw new RuntimeException("Something wrong", e);
        }
    }
}
