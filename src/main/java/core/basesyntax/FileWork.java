package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String[] resultList = new String[]{};

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String readerValue = reader.readLine();
            String regex = "[?.:!;]";

            if (readerValue == null) {
                return new String[]{};
            }

            while (readerValue != null) {
                String[] readerValueList = readerValue.split(" ");

                for (String value : readerValueList) {
                    if (value.toLowerCase().startsWith("w")) {
                        stringBuilder.append(value.toLowerCase().replaceAll(regex, "")).append(" ");
                    }
                }

                readerValue = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }

        if (stringBuilder.length() > 0) {
            resultList = stringBuilder.toString().split(" ");
            Arrays.sort(resultList);
        }

        return resultList;
    }
}
