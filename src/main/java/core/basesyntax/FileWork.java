package core.basesyntax;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String CHARACTER = "W";

    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return new String[]{fileName};
        }
        String[] words = fileName.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        char letter;
        String letter1;
        for (String word : words) {
            letter = word.charAt(0);
            letter1 = String.valueOf(letter);
            if (letter1.equals(SPECIFIED_CHARACTER) || letter1.equals(CHARACTER)) {
                stringBuilder.append(word);
            }
        }
        return new String[]{stringBuilder.toString().toLowerCase()};
    }
}
