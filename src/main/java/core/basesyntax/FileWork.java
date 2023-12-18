package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String string = getString(fileName);
        if (string.isEmpty()) {
            return new String[0];
        }
        String[] result = getResult(string);
        return result;
    }

    private static String[] getResult(String string) {
        string = string.toLowerCase();
        String[] stringSplit = string.split("\\W+");
        String[] worlds = new String[stringSplit.length];
        int count = 0;
        for (String world : stringSplit) {
            if (world.charAt(0) == 'w') {
                worlds[count++] = world;
            }
        }
        String[] result = (Arrays.copyOf(worlds, count));
        Arrays.sort(result);
        return result;
    }

    private static String getString(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        String string = stringBuilder.toString();
        return string;
    }
}
