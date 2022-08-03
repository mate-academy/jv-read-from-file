package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName)  {
        //write your code here
        String [] emptyArray = new String [0] ;
        StringBuilder stringBuilder=new StringBuilder();
       try{ File file =new File(fileName);
        BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
        String text = bufferedReader.readLine();
        while (text!=null){
            stringBuilder.append(text).append(" ");
            text=bufferedReader.readLine();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       String [] array=stringBuilder.toString().toLowerCase().split("[^A-Za-z0-9]+");
       String line="";
        for (int i = 0; i < array.length; i++) {
            if(array[i].startsWith("w"))
               line= line.concat(array[i]).concat(" ");
        }

        String []result=line.split(" ");
        if(result.length==1)
            return new String[0];
        Arrays.sort(result);
        return result;
    }
}
