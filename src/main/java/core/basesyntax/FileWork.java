package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String res = "";
            String list = "";
            List files = Files.readAllLines(Paths.get(fileName));
            if (files.equals("") || files.equals(null) || files.isEmpty()) {
                return new String[0];
            }
            for (int i = 0; i < files.size(); i++) {
                list += files.get(i) + " ";
            }
            String[] listSplit = list.split(" ");
            for (int i = 0; i < listSplit.length; i++) {
                if (listSplit[i].toLowerCase().charAt(0) == 'w') {
                    res += listSplit[i].toLowerCase() + "_";
                }
            }
            res = res.replaceAll("\\W", "");

            String[] result = res.trim().split("_");
            Arrays.sort(result);
            if (result.length == 1) {
                return new String[0];
            } else {
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
