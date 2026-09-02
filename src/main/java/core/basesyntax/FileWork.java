package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (stringBuilder.length() <= 2) {
            return new String[0];
        } else {
            String[] stringAll = stringBuilder.toString().split("[.,;:!?\\]\\[ ]");
            StringBuilder stringBuilderSecond = new StringBuilder();

            for (String str : stringAll) {
                if (str.length() > 0 && (str.charAt(0) == 'w' || str.charAt(0) == 'W')) {
                    stringBuilderSecond.append(str).append(",");
                }
            }
            if (stringBuilderSecond.length() <= 2) {
                return new String[0];
            }
            String strW = stringBuilderSecond.toString().toLowerCase();
            String[] strWArray = strW.split(",");
            Arrays.sort(strWArray);
            return strWArray;
        }
    }
}
