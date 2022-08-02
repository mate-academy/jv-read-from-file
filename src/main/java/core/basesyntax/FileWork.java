package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "W";
    private static final String SPECIFIED_CHARACTER_LOWER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String text = bufferedReader.readLine();
            while (text != null) {
                builder.append(text).append(" ");
                text = bufferedReader.readLine();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Can not find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can not read file", e);
        }
        String[] array = builder.toString().split("\\W+");
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith(SPECIFIED_CHARACTER_LOWER)
                    || array[i].startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        String[] output = new String[count];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith(SPECIFIED_CHARACTER_LOWER)
                    || array[i].startsWith(SPECIFIED_CHARACTER)) {
                output[index] = array[i].toLowerCase();
                index++;
            }
        }
        Arrays.sort(output);
        return output;
    }
}



