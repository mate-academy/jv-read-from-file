package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {

    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.equals("")) {
            return null;
        }
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int receivedByte = reader.read();
            if (receivedByte == -1) {
                return new String[]{};
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((char) receivedByte);
            while ((receivedByte = reader.read()) != -1) {
                stringBuilder.append((char) receivedByte);
            }
            String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
            ArrayList<String> listWordBeginsW = new ArrayList<>();
            for (String word: split) {
                if (word.toCharArray()[0] == 'w') {
                    listWordBeginsW.add(word);
                }
            }
            Collections.sort(listWordBeginsW);
            String[] resultArray = new String[listWordBeginsW.size()];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = listWordBeginsW.get(i);
            }
            System.out.println(listWordBeginsW);
            return resultArray;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
