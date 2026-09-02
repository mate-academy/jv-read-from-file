package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\kaste\\projects\\mateAc\\jv-read-from-file\\test2"; 
        String[] filteredWords = FileWork.readFromFile(filePath);
        System.out.println(Arrays.toString(filteredWords));
    }
}
