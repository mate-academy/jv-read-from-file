package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                Pattern re = Pattern.compile("[^A-Za-z0-9 ]+",Pattern.CASE_INSENSITIVE);
                Matcher m = re.matcher(line);
                String result = m.replaceAll("");
                String[] split = result.split(" ");
                for (String splited : split) {
                    String small = splited.toLowerCase();
                    int index = splited.indexOf("w");
                    int index2 = splited.indexOf("");
                    //char[] words = splited.toCharArray();
                    // if (words[0] == 'w' || words[0] == 'W') {
                    if (small.startsWith("w")) {
                        resultList.add(new String(small));
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}
/*
class Module1{
  public static void main(String[] asd){
  String sourcestring = "source string to match with pattern";
  Pattern re = Pattern.compile("[^A-Za-z0-9 ]+",Pattern.CASE_INSENSITIVE);
  Matcher m = re.matcher(sourcestring);
  String result = m.replaceAll("");
  }
}*/
//if (splits.equals("w") || splits.equals('W'))
// String[] split = value.split("\\W+");
