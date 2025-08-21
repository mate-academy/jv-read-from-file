package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> stringList;
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strings;
        try {
            stringList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e + " file not found");
        }
        for (int i = 0; i < stringList.size(); i++) {
            List<String> list = new ArrayList<>(List.of(stringList.get(i).split("\\W+")));
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i1).toLowerCase().startsWith("w")) {
                    arrayList.add(list.get(i1).toLowerCase());
                }
            }
        }
        strings = arrayList.toArray(new String[0]);
        Arrays.sort(strings);
        return strings;
    }
}
