package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int INITIAL_CAPACITY = 1000;

    public String[] readFromFile(String fileName) {
        try {
            int capacity = INITIAL_CAPACITY;
            String[] result = new String[capacity];
            int size = 0;

            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("File is not found: " + fileName);
                return new String[0];
            }

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split("\\W+");
                    for (String word : words) {
                        if (word.startsWith("w") || word.startsWith("W")) {
                            if (size == capacity) {
                                capacity *= 2;
                                result = Arrays.copyOf(result, capacity);
                            }
                            result[size++] = word.toLowerCase();
                        }
                    }
                }
            }

            result = Arrays.copyOf(result, size);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return new String[0];
        }
    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        try {
            String[] fileNames = {
                    "test1", "test2", "test3", "test4", "test5"
            };
            for (String fileName : fileNames) {
                System.out.println("file processing " + fileName);
                String[] result = fileWork.readFromFile(fileName);
                System.out.println(Arrays.toString(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
