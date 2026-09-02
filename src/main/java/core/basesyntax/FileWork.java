package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    public static final String frstLtrOfWrd = "w";
    public static final String punctRegex = "\\p{Punct}";
    public static final String lstRegex = "\\W+";

    public String[] readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder wordsStartsW = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String []arr = stringBuilder.toString().split(" ");
        for (int a = 0; a < arr.length; a++) {
            String firstChar = "" + arr[a].charAt(0);
            if (firstChar.equalsIgnoreCase(frstLtrOfWrd) && !arr[a].equals(" ")) {
                for (int b = 0; b < arr[a].length(); b++) {
                    String letterOfWord = "" + arr[a].charAt(b);
                    if (!Pattern.matches(punctRegex, letterOfWord)) {
                        wordsStartsW.append(letterOfWord.toLowerCase());
                    }
                }
                wordsStartsW.append(" ");
            }
        }
        String str = wordsStartsW.toString().trim();
        if (str.length() == 0) {
            return new String[0];
        }
        String[] arrOfWords = str.split(lstRegex);
        Arrays.sort(arrOfWords);
        return arrOfWords;
    }
}

