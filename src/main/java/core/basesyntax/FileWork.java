package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder bd = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                bd.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(" ", e);
        }
        String[] udd = bd.toString().toLowerCase().split("\\W+");
        StringBuilder res = new StringBuilder();
        for (String ud : udd) {
            if (ud.startsWith("w")) {
                res.append(ud).append(" ");
            }
        }
        String[] result = res.toString().split(" ");
        if (result.length == 0 || (result.length == 1 && result[0].isEmpty())) {
            return new String[] {};
        }
        Arrays.sort(result);
        return result;
    }
}
