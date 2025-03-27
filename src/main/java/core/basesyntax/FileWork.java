package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        List<String> newWorlds = new ArrayList<>();
        File file = new File(fileName);
        try {
            String result = Files.readAllLines(file.toPath()).toString().replaceAll("[\\[\\]]", "");
            String[] st = result.split(" ");
            for (String s : st) {
                if (s.startsWith("w") || s.startsWith("W")) {
                    newWorlds.add(s.toLowerCase().replaceAll("[!?,.]", ""));
                }
            }
            Arrays.sort(newWorlds.toArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] final_arr = newWorlds.toArray(new String[0]);
        Arrays.sort(final_arr);

        return final_arr;
    }
}
