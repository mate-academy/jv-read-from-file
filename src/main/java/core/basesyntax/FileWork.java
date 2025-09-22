package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        int count = readFromFileCountHelper(fileName);
        int counter = 0;

        String[] resultArray = new String[count];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String value = br.readLine();
            while (value != null) {
                String[] array = value.split(" ");
                for (int i = 0; i < array.length; i++) {
                    if (array[i].charAt(0) == 'w' || array[i].charAt(0) == 'W') {
                        String[] rr = array[i].split("\\W+");
                        resultArray[counter] = rr[0].toLowerCase();
                        counter++;
                    }
                }
                value = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Arrays.sort(resultArray);;
        return resultArray;
    }
    public int readFromFileCountHelper(String fileName) {
        int count = 0;
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String value = br.readLine();
            while (value != null) {
                String[] resultarr = value.split(" ");
                    for (int i = 0; i < resultarr.length; i++) {
                        if (resultarr[i].charAt(0) == 'w' ||  resultarr[i].charAt(0) == 'W') {
                            count++;
                        }
                    }
                    value = br.readLine();
                }
            br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
        }
        return count;
    }
}
