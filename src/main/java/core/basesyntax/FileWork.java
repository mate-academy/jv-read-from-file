package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String strFile = readFile(fileName);
        if (strFile.isEmpty()) {
            return new String[0];
        }
        String[] split = strFile.split("\\W+");
        for (String str : split) {
            if (str.charAt(0) == 'w' || str.charAt(0) == 'W') {
                stringBuilder.append(str).append(" ");
            }
        }
        String string = stringBuilder.toString().toLowerCase();
        String[] result = string.split(" ");
        Arrays.sort(result);
        if (result[0].equals("")) {
            result = new String[0];
        }
        return result;
    }

    public String readFile(String fileName) {
        StringBuilder sbLocal = new StringBuilder();
        String combine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((combine = bufferedReader.readLine()) != null) {
                sbLocal.append(combine).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + fileName, e);
        }
        return sbLocal.toString();
    }
}
