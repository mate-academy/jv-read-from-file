package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        String file = "file.txt";

        FileWork fileWork = new FileWork();
        String[] words = fileWork.readFromFile(file);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
