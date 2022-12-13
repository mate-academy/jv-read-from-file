package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        try{
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                builder.append(value);
            }
            String fileTxt = builder.toString();
            String[] separetedFileTxt = fileTxt.split(" ");
            String[] answer = new String[]{};
            for (String wWord : separetedFileTxt) {
                if (wWord.charAt(0) == 'w' || wWord.charAt(0) == 'W'){
            }
        } catch (FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IOExeption");
        }

        //write your code here
        return null;
    }
}
