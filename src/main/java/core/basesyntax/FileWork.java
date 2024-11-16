package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        //write your code here
        File file = new File(fileName);
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]+",Pattern.CASE_INSENSITIVE);;
        Matcher matcher;
        String result;
        String[] arrayString;
        List<String> resultList = new ArrayList<>();

        try {
            List<String> stringList = Files.readAllLines(file.toPath());
            for(String string : stringList) {
                matcher = pattern.matcher(string);
                result = matcher.replaceAll("").toLowerCase();
                arrayString = result.split(" ");
                for(int i = 0; i < arrayString.length; i++) {
                    if(arrayString[i].charAt(0) == 'w') {
                        resultList.add(arrayString[i]);
                    }
                }
            }
            arrayString = new String[resultList.size()];
            arrayString = resultList.toArray(new String[0]);
            Arrays.sort(arrayString);
        } catch (IOException e) {
            throw new FileNotFoundException("Can't read data from file");
        }
        return arrayString;
    }
}
