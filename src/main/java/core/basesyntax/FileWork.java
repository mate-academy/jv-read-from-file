package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<String>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder stringBuilder = new StringBuilder();
                int value = br.read();
                while (value != -1) {
                    stringBuilder.append((char) value);
                    value = br.read();
                }
                String[] split = stringBuilder.toString().split("\\W+");
                for (String splits : split) {
                    splits = splits.toLowerCase();
                    if (splits.startsWith("w")) {
                        result.add(splits);
                    }
                }
                result.sort(String::compareTo);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not open file " + fileName, e);
        }
        return result.toArray(new String[result.size()]);
    }
}
