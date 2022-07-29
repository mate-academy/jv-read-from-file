package core.basesyntax;

import java.io.*;
import java.util.stream.Stream;

public class FileWork {

    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        StringBuilder input = new StringBuilder();
        StringBuilder output = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int temp = bufferedReader.read();
            while (temp != -1) {
                input.append((char) temp);
                temp = bufferedReader.read();
            }
            String[] array = input.toString().split("[ ',.?!\n]");
            for (String word : array) {
                if (word.equals("")) {
                    continue;
                }
                char[] chars = word.toCharArray();
                if (chars[0] == 'w' || chars[0] == 'W') {
                    output.append(word.toLowerCase()).append(" ");
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file");
        }
        String[] strings = (output.toString().split(" "));
        if (strings.length == 1) {
            return EMPTY_ARRAY;
        }
        return Stream.of(strings).sorted().toArray(String[]::new);
    }
}
