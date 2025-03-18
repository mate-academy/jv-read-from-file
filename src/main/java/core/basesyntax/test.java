package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String fileName = "Welcome world! This is a test with words starting with W.";
        String[] splitSequence = fileName.split("\\W+"); // Split by non-word characters

        List<String> filterList = new ArrayList<>(); // Initialize the list

        for (String word : splitSequence) {
            if (word.toLowerCase().startsWith("w")) { // Check if word starts with "w"
                filterList.add(word); // Add to list
            }
        }

        // Print the filtered list
        System.out.println(filterList);
    }
}