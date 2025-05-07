package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {
    private static final int lengthNull = 0;
    private static final int index = 0;

    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                String[] arr = data.split("[ .!?]");
                for (String word : arr) {
                    if (word.startsWith("w")) {
                        stringBuilder.append(word).append(" ");
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        if (stringBuilder.length() == lengthNull) {
            return new String[index];
        }
        String[] resArr = stringBuilder.toString().split(" ");
        Arrays.sort(resArr);
        return resArr;
    }
}
