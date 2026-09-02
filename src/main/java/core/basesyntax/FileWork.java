package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] filterWord;
        int count = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bf.readLine()) != null) {
                String[] token = line.split("\\W+");

                for (String t : token) {
                    String s = t.toLowerCase().trim();
                    if (! s.isEmpty() && s.charAt(0) == 'w') {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read this file");
        }

        filterWord = new String[count];
        int index = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bf.readLine()) != null) {
                String[] token = line.split("\\W+");

                for (String t : token) {
                    String s = t.toLowerCase().trim();
                    if (! s.isEmpty() && s.charAt(0) == 'w') {
                        filterWord[index] = s;
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read this file");
        }

        for (int i = 0; i < filterWord.length - 1; i++) {
            for (int j = i + 1; j < filterWord.length; j++) {
                if (filterWord[i].compareTo(filterWord[j]) > 0) {
                    String temp = filterWord[i];
                    filterWord[i] = filterWord[j];
                    filterWord[j] = temp;
                }
            }
        }
        return filterWord;
    }
}
