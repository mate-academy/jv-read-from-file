package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder result = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
          String line = bufferedReader.readLine();
            if (line == null){
                return new String[]{};
            }
          while (line != null){
            String[] splittedLine = line.split(" ");
              for (int i = 0; i < splittedLine.length; i++) {
                  splittedLine[i] = splittedLine[i].toLowerCase();
                  if("w".equals(String.valueOf(splittedLine[i].toLowerCase().charAt(0)))){
                      result.append(splittedLine[i]).append(".");
                  }

              }
              line = bufferedReader.readLine();
          }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] res = result.toString().split("\\.");
        return res;
    }
}
