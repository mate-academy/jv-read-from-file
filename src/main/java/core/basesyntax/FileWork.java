package core.basesyntax;










import java.util.Arrays;

public class FileWork {

    private static final char KEY_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find a file " + fileName + " ", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a line ", e);
        }
        String[] allWords = new String(stringBuilder.toString()).toLowerCase().split("\\W+");
        if (allWords[0].isEmpty()) {
            return new String[0];
        }
        int amountOfWords = 0;
        for (String word : allWords) {
            if (word.charAt(0) == KEY_CHAR) {
                amountOfWords++;
            }
        }
        if (amountOfWords == 0) {
            return new String[0];
        }
        String[] filteredWords = new String[amountOfWords];
        int counter = 0;
        for (String word : allWords) {
            if (word.charAt(0) == KEY_CHAR) {
                filteredWords[counter] = word;
                counter++;
            }
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
