package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilderWArray = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                String [] nullArray = new String[0];
                return nullArray;
            } else {
                while (value != null) {
                    stringBuilder.append(value).append(" ");
                    value = reader.readLine();
                }
                String resultString = stringBuilder.toString().toLowerCase();
                String[] allArray = resultString.split("\\W+");
                for (int i = 0; i < allArray.length; i++) {
                    char[] charArray = allArray[i].toCharArray();
                    if (charArray[0] == 'w') {
                        stringBuilderWArray.append(allArray[i]).append(" ");
                    }
                }
                String allArrayWithW = stringBuilderWArray.toString();
                if (!allArrayWithW.equals("")) {
                    String[] arrayWithW = allArrayWithW.split(" ");
                    String[] sortedWArray = new String[arrayWithW.length];
                    arrayWithW = Stream.of(arrayWithW)
                            .sorted()
                            .toArray(String[]::new);
                    return arrayWithW;
                } else {
                    String[] sortedWArray = new String[0];
                    return sortedWArray;
                }
            }
        } catch (IOException e) {
            String [] nullArray = new String[0];
            return nullArray;
        }

    }
}
