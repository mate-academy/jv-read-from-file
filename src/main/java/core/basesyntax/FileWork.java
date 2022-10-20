package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilderWArray = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            } else {
                while (value != null) {
                    stringBuilder.append(value).append(" ");
                    value = reader.readLine();
                }
                String resultString = stringBuilder.toString().toLowerCase();
                String[] allArray = resultString.split("\\W+");
                for (int i = 0; i < allArray.length; i++) {
                    char[] charArray = allArray[i].toCharArray();
                    if (charArray[0] == SPECIFIED_CHARACTER) {
                        stringBuilderWArray.append(allArray[i]).append(" ");
                    }
                }
            }
            String result = stringBuilderWArray.toString().toLowerCase();
            String[] arrayW = new String[]{""};
            if (result.equals("")) {
                return new String[]{};
            }
            arrayW = result.split(" ");
            Arrays.sort(arrayW);
            return arrayW;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
