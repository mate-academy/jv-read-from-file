package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char FILTER_CHARACTER = 'w';
    private static final String SEPARATOR_CHARACTER = "_";
    private static final String SECOND_SEPARATOR_CHARACTER = " ";
    private static final String EMPTY_CHARACTER = "";

    public String[] readFromFile(String fileName) {
        try {
            String res = "";
            StringBuilder list = new StringBuilder();
            List<String> files = Files.readAllLines(Paths.get(fileName));
            if (files.isEmpty()) {
                return new String[0];
            }
            for (int i = 0; i < files.size(); i++) {
                list.append(files.get(i)).append(SECOND_SEPARATOR_CHARACTER);
            }
            String[] listSplit = list.toString().split(SECOND_SEPARATOR_CHARACTER);
            for (int i = 0; i < listSplit.length; i++) {
                if (listSplit[i].toLowerCase().charAt(0) == FILTER_CHARACTER) {
                    res += listSplit[i].toLowerCase() + SEPARATOR_CHARACTER;
                }
            }
            res = res.trim().replaceAll("\\W", EMPTY_CHARACTER);
            if (res.isEmpty()) {
                return new String[0];
            }
            String[] result = res.split(SEPARATOR_CHARACTER);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
