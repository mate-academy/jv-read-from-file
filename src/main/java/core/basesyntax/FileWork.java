package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list;
        String[] result;
        File file = new File(fileName);

        try {
            list = Files.readAllLines(file.toPath());
            list.replaceAll(String::toLowerCase);

            StringBuilder str = new StringBuilder();
            for (String s : list) {
                str.append(s).append(" ");
            }

            String[] split = str.toString().split("\\W+");

            ArrayList<String> dd = new ArrayList<>();
            for (String word : split) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    dd.add(word);
                }
            }

            dd.sort(String::compareTo);

            result = dd.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

        return result;
    }
}
