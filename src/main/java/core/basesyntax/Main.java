package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();

        for (int i = 1; i <= 5; i++) {
            String nameOfFile = "test" + i;
            String[] words = fileWork.readFromFile(nameOfFile);
            System.out.println("\n=== TEST " + i + " ===");

            if (words.length == 0) {
                System.out.println("Plik jest pusty lub nie zawiera słów na 'w'");
            } else {
                for (String word : words) {
                    System.out.println(word);
                }
            }
        }
    }
}
