package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char STATIC_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file or line" + fileName, e);
        }
        String[] arrayOfWorlds = stringBuilder.toString().toLowerCase().split("\\W+");
        if (arrayOfWorlds[0].isEmpty()) {
            return new String[0];
        }
        int numberWorlds = 0;
        for (String world : arrayOfWorlds) {
            if (world.charAt(0) == STATIC_CHAR) {
                numberWorlds++;
            }
        }
        if (numberWorlds == 0) {
            return new String[0];
        }
        int index = 0;
        String[] sortArrayWorlds = new String[numberWorlds];
        for (String world : arrayOfWorlds) {
            if (world.charAt(0) == STATIC_CHAR) {
                sortArrayWorlds[index] = world;
                index++;
            }
        }
        Arrays.sort(sortArrayWorlds);
        return sortArrayWorlds;
    }
}
