package core.basesyntax;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] words = fileName.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("w") || word.startsWith("W")) {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        return stringBuilder.toString().trim().split(" ");
    }
}
