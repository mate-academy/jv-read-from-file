package core.basesyntax;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileWork {
    private static final int INDEX_OF_FIRST_LETTER = 0;
    private static final char FIRST_LETTER_OF_THE_WORD = 'w';


    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();


            while (value != null) {
                String[] words = value.toLowerCase().split("\\W+");


                for (int i = 0; i < words.length; i++) {
                    char[] word = words[i].toCharArray();


                    if (word[INDEX_OF_FIRST_LETTER] == FIRST_LETTER_OF_THE_WORD) {
                        builder.append(words[i]).append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + file, e);
        }


        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().split(" ");


        for (int i = 0; i < result.length; i++) {
            for (int k = i + 1; k < result.length; k++) {
                if (result[i].compareTo(result[k]) > 0) {
                    String temp = result[i];
                    result[i] = result[k];
                    result[k] = temp;
                }
            }
        }
        return result;
    }
}