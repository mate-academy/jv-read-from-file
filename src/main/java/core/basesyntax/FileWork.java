package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final char SORTED_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        String[] dataList = new String[0];
        try {
            String data = Files.readAllLines(Path.of(fileName)).toString().toLowerCase();
            if (data.equals("")) {
                return dataList;
            }
            String[] dataListUnsorted = data.split("[\\p{Punct}|\\p{Space}]");
            for (String element : dataListUnsorted) {
                if (!element.equals("")){
                    if (element.toCharArray()[0] == SORTED_SYMBOL) {
                        String[] newArray = Arrays.copyOf(dataList, dataList.length + 1);
                        newArray[newArray.length - 1] = element;
                        dataList = newArray;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("HELP");
        }
        Arrays.sort(dataList);
        return dataList;
    }
}
