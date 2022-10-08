package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {

    public static String removePunctuations(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        String text = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            if (value == null) {
                String[] nulll = new String[0];
                return nulll;
            }

            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            text = stringBuilder.toString().toLowerCase();
            text = removePunctuations(text);
            //String test = text;
//            for (int i = 0; i < split.length; i++) {
//                stringBuilder.append(split[i]).append(" ");
//            }

            String text1 = text;
            char[] chars = text1.toCharArray();

            char[] chars1 = chars;

            StringBuilder stringBuilder1 = new StringBuilder();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'w') {
                    while (chars[i] != ' ') {
                        stringBuilder1.append(chars[i]);
                        i++;
                    }
                    stringBuilder1.append(" ");
                    String resTest = stringBuilder1.toString();
                }
            }

            String text2 = stringBuilder1.toString();
            String testTeset = text2;

            String[] resSplit = text2.split(" ");

            Arrays.sort(resSplit);

            String[] edde = resSplit;

            //whenever which was which was worse
            return resSplit;


        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        //return res;
    }
}
