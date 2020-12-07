package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        List<String> data;
        List<String> returnStrings = new ArrayList<>();
        try {
            data = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i).split("\\W+");
            for (String str : strings) {
                if (Character.toLowerCase(str.charAt(0)) == 'w') {
                    returnStrings.add(str.toLowerCase());
                }
            }
        }

        Collections.sort(returnStrings);
        return returnStrings.toArray(new String[0]);
    }
}
