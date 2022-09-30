package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String[] result;
        String[] words = null;
        Path path = Paths.get(fileName);
        try {
            String readed = Files.readString(path);
            words = readed.split("\\W+");
            result = filter(words);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(result));
        Arrays.sort(result);
        return result;
    }

    private String[] filter(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            s = s.toLowerCase();
            if (s.length() > 1 && s.charAt(0) == 'w') {
                result.add(s);
                sb.append(s).append(" ");
            }
        }

        return result.toArray(new String[0]);
    }
}
