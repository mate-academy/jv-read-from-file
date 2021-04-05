package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final char FILTER_CHARACTER = 'w';
    public static final String SEPARATOR_CHARACTER = "_";
    public static final String SECOND_SEPARATOR_CHARACTER = " ";
    public static final String EMPTY_CHARACTER = "";

    public String[] readFromFile(String fileName) {
        try {
            String res = "";
            String list = "";
            List files = Files.readAllLines(Paths.get(fileName));
            if (files.equals("") || files.equals(null) || files.isEmpty()) {
                return new String[0];
            }
            for (int i = 0; i < files.size(); i++) {
                list += files.get(i) + SECOND_SEPARATOR_CHARACTER;
            }
            String[] listSplit = list.split(SECOND_SEPARATOR_CHARACTER);
            for (int i = 0; i < listSplit.length; i++) {
                if (listSplit[i].toLowerCase().charAt(0) == FILTER_CHARACTER) {
                    res += listSplit[i].toLowerCase() + SEPARATOR_CHARACTER;
                }
            }
            res = res.replaceAll("\\W", EMPTY_CHARACTER);

            String[] result = res.trim().split(SEPARATOR_CHARACTER);
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
