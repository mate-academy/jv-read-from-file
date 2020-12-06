package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        List<String> data;
        List<String> returnStrings = new ArrayList<>();
        try {
            data = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i).split(" ");
            for (String str : strings) {
                if (str.charAt(0) == 'w' || str.charAt(0) == 'W') {
                    int lastSymbol = str.length() - 1;
                    if (str.charAt(lastSymbol) == '!'
                            || str.charAt(lastSymbol) == '.'
                            || str.charAt(lastSymbol) == '?'
                            || str.charAt(lastSymbol) == ',') {
                        returnStrings.add(str.toLowerCase().substring(0, lastSymbol));
                    } else {
                        returnStrings.add(str.toLowerCase());
                    }
                }
            }
        }

        returnStrings = returnStrings.stream().sorted().collect(Collectors.toList());
        return returnStrings.toArray(new String[0]);
    }
}
