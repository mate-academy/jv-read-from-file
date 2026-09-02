import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.checkedList;
import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {
        String filePath = "file1.txt";
        String[] result = Arrays(filePath);
        for(String ae : result ){
            System.out.println(ae);
        }
    }


    public static String[] Arrays(String line) {
        {
        }
        try (FileReader fr = new FileReader("file1.txt");
             BufferedReader br = new BufferedReader(fr)) {
            line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException("error create file", e);
        }
            if (line == null) {
                return new String[0];
            }
            line = line.toLowerCase();
            String[] words = line.split(" ");
            ArrayList<String> nachalo = new ArrayList<>();
            String[] arr = new String[nachalo.size()];
            for (String word : words) {
                if (word.indexOf('w')== 0) {
                    nachalo.add(word);
                }
            }
            if (nachalo.isEmpty()) {
                return new String[0];
            }
            Collections.sort(nachalo);
            return nachalo.toArray(new String[0]);
        }
    }