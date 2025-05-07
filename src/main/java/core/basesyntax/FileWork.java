package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> list;
        try {
            list = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read", e);
        }
        String[] mass = list.toString().toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String ma : mass) {
            if (ma.startsWith("w")) {
                builder.append(ma).append(" ");
            }
        }
        String result = builder.toString();
        if (result.length() == 0) {
            return new String[] {};
        }
        String[] res = result.split(" ");
        Arrays.sort(res);
        return res;
    }
}
