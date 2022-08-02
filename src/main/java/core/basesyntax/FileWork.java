package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public class FileWork {
    public static void main (String[]args){
        FileWork ff = new FileWork();
       ff.readFromFile("test2");
    }
    public String [] readFromFile(String fileName) {
        File file = new File (fileName);
        String [] allWords;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String readed = reader.readLine().toLowerCase(Locale.ROOT);

            allWords = readed.split("[\\W]");

            System.out.println(Arrays.toString(allWords));




            }catch (IOException e) {
            throw new RuntimeException(" ddd ");
        }
            return allWords;
    }
}
