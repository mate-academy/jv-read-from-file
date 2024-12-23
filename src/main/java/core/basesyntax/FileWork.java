package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] finalWords;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader (fileName))) {
            String result = bufferedReader.readLine();
            System.out.println(result);
            String[] words = result.split("\\W+");
            int count = 0;
            for (String s : words) {
                String first = s.toLowerCase().substring(0,1);
                if (first.equals("w")) {
                    count++;
                }
            }
            finalWords = new String[count];
            count = 0;
            ArrayList<String> list = new ArrayList<>();
            for (String s : words) {
                System.out.println(s);
                String first = s.toLowerCase().substring(0,1);
                if (first.equals("w")) {
                    list.add(s.toLowerCase());
                }
            }
            Collections.sort(list);
            System.out.println(list);
            for (String s : list) {
                System.out.println(s);
                finalWords[count] = s;
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return finalWords;
    }
}
