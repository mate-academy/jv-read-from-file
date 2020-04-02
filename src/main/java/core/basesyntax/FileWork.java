package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    public static String[] readFromFile(String fileName) {
        final StringBuilder sb = new StringBuilder();
        List<String> reader ;
        Path filePath = Paths.get(fileName);
        String [] split = new String[0];
        try {
            reader = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Причина в том, что " + e);
        }
        if (reader.size() > 0) {
            for (String a : reader) {
                sb.append(a.toLowerCase() + " ");
            }
            split = sb.toString().split(" ");
            String worlds = "";
            for (String s : split) {
                if (s.charAt(0) == ('w')) {
                    worlds = worlds + s.replaceAll("\\W","") + " ";
                }
                split = worlds.split(" ");
            }
            if (split.length == 1) {
                split = new String [0];
            }
            Arrays.sort(split);
        }
        return split;
    }
}
