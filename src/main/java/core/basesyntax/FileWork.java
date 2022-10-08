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

            String text1 = text;

            StringBuilder stringBuilder1 = new StringBuilder();

            String[] strings = text1.split(" ");

            for (int i = 0; i < strings.length; i++) {
                if (strings[i].charAt(0) == 'w') {
                    stringBuilder1.append(strings[i]).append(" ");
                }
            }

            String text2 = stringBuilder1.toString();

            String testTeset = text2;

            if (text2 == "") {
                String[] nulll = new String[0];
                return nulll;
            }

            String[] resSplit = text2.split(" ");

            Arrays.sort(resSplit);

            String[] edde = resSplit;


            return resSplit;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
