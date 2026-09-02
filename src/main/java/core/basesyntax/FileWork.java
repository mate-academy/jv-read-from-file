package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader fileRead = new BufferedReader(new FileReader(file));
            if (fileRead.readLine() != null) {
                String allFile = Files.readAllLines(file.toPath()).toString().toLowerCase();
                String[] res = allFile.split("\\W+");
                String cuttedArray = "";
                for (int i = 0; i < res.length; i++) {
                    if (res[i].startsWith("w")) {
                        cuttedArray += res[i] + " ";
                    }
                }
                if (!cuttedArray.isEmpty()) {
                    String[] result = cuttedArray.split(" ");
                    Arrays.sort(result);
                    return result;
                } else {
                    String[] result = new String[0];
                    return result;
                }

            } else {
                String[] result = new String[0];
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.");
        }
    }
}
