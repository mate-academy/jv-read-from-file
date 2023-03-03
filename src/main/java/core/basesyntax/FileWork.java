package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final int LITERAL_POSITION = 0;
    private static final char REQUIRED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           String string = bufferedReader.readLine();

           while (string != null){
               String[] words = string.toLowerCase().split("\\W+");

               for(int i = 0; i < words.length; i++) {
                   char[] word = words[i].toCharArray();
                   if (word[LITERAL_POSITION] == REQUIRED_CHARACTER) {
                       stringBuilder.append(words[i]).append(" ");
                   }
               }
               string = bufferedReader.readLine();
           }
       } catch (IOException e) {
           throw new RuntimeException("Can't read file" + file, e);
       }

       if(stringBuilder.length()==0) {
           return new String[0];
       }
       String[] result = stringBuilder.toString().split(" ");

       for (int i = 0; i < result.length; i++) {
           for (int j = 0; j < result.length; j++) {
               if(result[i].compareTo(result[j]) > 0) {
                   String temp = result[i];
                   result[i] = result[j];
                   result[j] = temp;
               }
           }
       }
        return result;
    }
}
