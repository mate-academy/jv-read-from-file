package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public static void main(String[] args) {
        FileWork test = new FileWork();

        System.out.println(Arrays.toString(test.readFromFile("test3")));
    }

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            for (int lineNumber = 1; (line = reader.readLine()) != null; lineNumber++) {
                for (String word:line.split(" ")) {
                    if (word.toLowerCase().startsWith("w")) {
                        if (word.endsWith(".") || word.endsWith("!") || word.endsWith("?")) {
                            stringBuilder.append(word.substring(0,word.length() - 1)
                                    .toLowerCase()).append(" ");
                        } else {
                            stringBuilder.append(word.toLowerCase()).append(" ");
                        }
                    }
                }
            }
            String[] result = new String[stringBuilder.toString().split(" ").length];
            for (int i = 0; i < result.length; i++) {
                result[i] = stringBuilder.toString().split(" ")[i];
            }
            if (! result.toString().toLowerCase().startsWith("w") && result.length == 1) {
                return new String[0];
            }
            return bubbleSort(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesn`t exist", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t work with file", e);
        }
    }

    public static String[] bubbleSort(String[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    String temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        return arr;
    }
}
