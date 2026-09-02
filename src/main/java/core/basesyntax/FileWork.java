package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String sourcestring = stringBuilder.toString().replace('\n', ' ');
        Pattern re = Pattern.compile("[^A-Za-z0-9 ]+",Pattern.CASE_INSENSITIVE);
        Matcher m = re.matcher(sourcestring);
        String[] result = m.replaceAll("").toLowerCase().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i].charAt(0) == 'w') {
                builder.append(result[i]).append(" ");
            }
        }
        if (builder.toString().length() == 0) {
            return new String[0];
        }
        String[] resultArray = builder.toString().split(" ");
        int size = resultArray.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < resultArray.length; j++) {
                if (resultArray[i].compareTo(resultArray[j]) > 0) {
                    String temp = resultArray[i];
                    resultArray[i] = resultArray[j];
                    resultArray[j] = temp;
                }
            }
        }
        return resultArray;
    }
}
