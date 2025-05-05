package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        int arrSize = 0;
        int arrStep = 0;

        FileReader fileReaderFirst;
        try {
            fileReaderFirst = new FileReader(myFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t reading file", e);
        }

        Scanner scannerFirst = new Scanner(fileReaderFirst);

        while (scannerFirst.hasNextLine()) {
            String[] words = scannerFirst.nextLine().split(" ");
            for (String word : words) {
                if (word.toLowerCase().charAt(0) == 'w') {
                    arrSize++;
                }
            }
        }

        FileReader fileReaderSecond;
        try {
            fileReaderSecond = new FileReader(myFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t reading file", e);
        }

        String[] array = new String[arrSize];
        Scanner scannerSecond = new Scanner(fileReaderSecond);

        while (scannerSecond.hasNextLine()) {
            String[] wordsWithW = scannerSecond.nextLine().split(" ");
            for (String word : wordsWithW) {
                if (word.toLowerCase().charAt(0) == 'w') {
                    array[arrStep] = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    arrStep++;
                }
            }
        }
        Arrays.sort(array);
        return array;
    }
}
