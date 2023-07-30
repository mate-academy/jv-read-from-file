package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        //write your code here
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }

        fileContent = fileContent.toLowerCase();
        //delete punctuation symbols except hyphens inside words
        fileContent = fileContent.replaceAll("[^\\w\\-]+", " ");

        /* Match (delete) words not beginning with certain character "w"
        https://stackoverflow.com/questions/56289683/
        match-words-not-beginning-with-certain-character */
        fileContent = fileContent.replaceAll("(?<!\\S)[^\\sw]\\S*", " ");
        fileContent = fileContent.trim();

        if (fileContent.length() == 0) {
            return new String[0];
        }

        /* split text into words and exclude hyphens
        https://stackoverflow.com/questions/21354399/split-text-into-words-and-exclude-hyphens */
        final String[] words = fileContent.split("[^\\w\\-]+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FileWork().readFromFile("")));
    }
}
