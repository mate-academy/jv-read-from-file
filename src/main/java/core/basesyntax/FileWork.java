package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private StringBuilder builder = new StringBuilder();
    private StringBuilder result = new StringBuilder();
    private String[] empty = new String[0];
    private int arrayLenght = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("No file");
        }

        String[] bigArray = builder.toString().toLowerCase().split(" ");
        Arrays.sort(bigArray);
        Pattern pattern = Pattern.compile("\\b[w][a-z]+\\b");
        for (String i: bigArray) {
            Matcher matcher = pattern.matcher(i);
            if (matcher.find()) {
                result.append(i).append(" ");
                arrayLenght++;
            }
        }
        String[] resultArray = result.toString().split("\\W+");
        Arrays.sort(resultArray);
        return (arrayLenght > 0) ? resultArray : empty;
    }
}
