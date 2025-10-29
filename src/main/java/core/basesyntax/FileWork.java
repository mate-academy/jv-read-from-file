package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final int SPECIFIED_POSITION = 0;
    private final StringBuilder stb = new StringBuilder();
    private final List<String> stringList = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();

            while (value != -1) {
                stb.append((char) value);
                value = bufferedReader.read();
            }

            String[] inputString = stb.toString()
                    .replaceAll("[\\p{Punct}\\s]+", " ")
                    .toLowerCase()
                    .split(" ");

            for (String s : inputString) {
                if (s != null && !s.isEmpty()
                        && s.charAt(SPECIFIED_POSITION) == SPECIFIED_CHARACTER) {
                    stringList.add(s);
                }
            }

            String[] stringArray = stringList.toArray(new String[SPECIFIED_POSITION]);
            Arrays.sort(stringArray);
            return stringArray;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find the file.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file.", e);
        } catch (Exception e) {
            throw new RuntimeException("Smth went wrong", e);
        }
    }
}
