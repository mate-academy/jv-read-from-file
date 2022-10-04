package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> fileInfo;
        StringBuilder res = new StringBuilder();
        try {
            file.createNewFile();
            fileInfo = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        if (fileInfo.isEmpty()) {
            return new String[0];
        }
        String str = fileInfo.toString();
        for (String info : str.split(" ")) {
            String inf = info.replaceAll("\\p{Punct}", "").toLowerCase();
            if (inf.charAt(0) == 'w') {
                res.append(inf).append(" ");
            }
        }
        String[] result = res.toString().split(" ");
        Arrays.sort(result);
        return (!result[0].contains("w")) ? new String[0] : result;
    }
}
