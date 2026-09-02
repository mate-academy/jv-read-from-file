package core.basesyntax;

import java.util.Arrays;

public class FileWork {
    private static final char CHAR_AT_WORD_START = 'w';
    private static final int START_OF_WORD_INDEX = 0;
    private ReadData readData = new ReadData();

    public String[] readFromFile(String fileName) {
        if (readData.readData(fileName).equals("")) {
            return new String[0];
        }
        String lowerCaseData = readData.readData(fileName).toLowerCase();
        String[] dataAsArray = lowerCaseData.split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dataAsArray.length; i++) {
            if (dataAsArray[i].charAt(START_OF_WORD_INDEX) == CHAR_AT_WORD_START) {
                builder.append(dataAsArray[i])
                        .append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] resultArray = builder.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
