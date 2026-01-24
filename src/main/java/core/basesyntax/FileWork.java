package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static void main(String[] args) {
        String sentence = "Width world Wide web";
        filterOut(sentence, "w");
    }

    private static String[] filterOut(String sentence, String filter) {
        String[] split = sentence.toLowerCase().split("\\W+");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            if (s.startsWith(filter)) {
                list.add(s);
            }
        }
        list.sort(null);
        return list.toArray(new String[0]);
    }

    public String[] readFromFile(String fileName) throws IOException {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] filtered = filterOut(line, "w");
                result.addAll(Arrays.asList(filtered));
            }
        }

        result.sort(null);
        return result.toArray(new String[0]);
    }

}

