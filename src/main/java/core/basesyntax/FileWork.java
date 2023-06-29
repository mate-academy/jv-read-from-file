package core.basesyntax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
            String[] words = fileName.split("\\W+");
            StringBuilder filteredWords = new StringBuilder();
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    filteredWords.append(word.toLowerCase()).append(" ");
                }
            }
            String[] result = filteredWords.toString().trim().split(" ");
            return result;
        } catch (IOException e) {
            throw new RuntimeException("can`t reach file", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException("can`t reach file", e);
                }
            }
        }
    }
}
