package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile("test2");

        for (String word : result) {
            System.out.println(word);
        }
    }
}
