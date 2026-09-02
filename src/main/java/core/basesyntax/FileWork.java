package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String text = "";
        try {
            text += Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        text = text.substring(1,text.length() - 1);
        String[] temp = text.split(" ");
        int count = 0;
        for (String start : temp) {
            start = start.toLowerCase().replaceAll("([^A-Za-z])", "");
            if (start.toLowerCase().startsWith("w")) {

                count++;
            }
        }
        int tt = 0;
        String[] result = new String[count];
        for (String start : temp) {
            if (start.toLowerCase().startsWith("w")) {
                result[tt] = start.toLowerCase().replaceAll("([^A-Za-z])", "");
                tt++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
