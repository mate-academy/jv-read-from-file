package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        Path path = file.toPath();
        StringBuilder stringBuilder = new StringBuilder();

        List<String> strings = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (strings.size() == 0) {
            return new String[0];
        }
        for (String str : strings) {
            String replaceAll = str.toLowerCase().replaceAll("[^a-z0-9 ]", "");

//            System.out.println("replaceAll = " + replaceAll);

            for (String s : replaceAll.split(" ")) {
                if (s.charAt(0) == 'w') {
                    stringBuilder.append(s).append(" ");
                }
            }
        }
//        System.out.println("stringBuilder.toString() = " + stringBuilder.toString().toLowerCase());

        String[] split = stringBuilder.toString().split(" ");
        Arrays.sort(split);
        return split;
    }
}
