package core.basesyntax;

import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splits = fileName.split("\\W+");
        int counter = 0;

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].charAt(0) == 'w' || splits[i].charAt(0) == 'W') {
                stringBuilder.append(splits[i].toLowerCase()).append(" ");
            }
        }
        String[] result = stringBuilder.toString().split(" ");
        System.out.println(Arrays.toString(result));
        return result;
    }
}
