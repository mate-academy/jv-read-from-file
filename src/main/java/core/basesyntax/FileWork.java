package core.basesyntax;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileWork {
    public String[] readFromFile(String fileName) {

            ArrayList<String> list = new ArrayList<>();

             try {
                 String content = Files.readString(Path.of(fileName));
                String [] resoult = content.split("\\s+");

                for(int i=0; i<resoult.length; i++){
                    String lowerCaseWords = resoult[i].toLowerCase();
                    lowerCaseWords = lowerCaseWords.replaceAll("[^a-z]","");

                    if(!lowerCaseWords.isEmpty() && lowerCaseWords.charAt(0) =='w'){
                        list.add(lowerCaseWords);
                    }



                }
             } catch (Exception e) {
                 System.out.println("Błąd: " + e.getClass().getName());
                 System.out.println("Wiadomość: " + e.getMessage());
                 e.printStackTrace();
             }



        return list.toArray(new String[0]);
    }
}
